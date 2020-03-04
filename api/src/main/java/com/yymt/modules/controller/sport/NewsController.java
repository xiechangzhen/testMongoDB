package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.CorporationEntity;
import com.yymt.entity.sport.MessageRecordEntity;
import com.yymt.entity.sport.NewsEntity;
import com.yymt.service.CorporationService;
import com.yymt.service.MessageRecordService;
import com.yymt.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * 新闻资讯
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@RestController
@RequestMapping("/news")
//@Api(tags = "新闻")
public class NewsController extends BaseController {

    public static final int NEWS_STATUS_AUDITING = 1;//审核中
    public static final int NEWS_STATUS_PASS = 2;//审核通过
    public static final int NEWS_STATUS_REFUSE = 3;//审核不通过
    public static final int NEWS_STATUS_DELETE = 4;//删除

    @Autowired
    private NewsService newsService;
    @Autowired
    private CorporationService corporationService;
    @Autowired
    MessageRecordService messageRecordService;


    /**
     * 首页新闻列表查询（获取该类下前3项）
     *
     * @param columnId 新闻栏目标识
     */
    @PostMapping("/indexList/{columnId}")
    //@ApiOperation("首页新闻列表查询（获取该类下前3项）")
    public RWapper indexListByCategoryAndTakeCount(
            @PathVariable int columnId) {
        return this.indexListByCategoryAndTakeCount(columnId, 3);
    }

    /**
     * 首页新闻列表查询
     *
     * @param columnId  新闻栏目标识
     * @param takeCount 取多少项内容
     */
    @PostMapping("/indexList/{columnId}/{takeCount}")
    //@ApiOperation("首页新闻列表查询")
    public RWapper indexListByCategoryAndTakeCount(
            @PathVariable int columnId
            , @PathVariable int takeCount) {
        List<NewsEntity> newsList = newsService.indexListByCategoryAndTakeCount(columnId, takeCount);
        return RWapper.ok().put("page", newsList).encode(isEncryption);
    }

    /**
     * 首页新闻列表查询
     *
     * @param columnId  新闻栏目标识
     * @param pageSize  页大小
     * @param pageIndex 页码（从1开始计数）
     */
    @PostMapping("/newsList/{columnId}/{pageSize}/{pageIndex}")
    //@ApiOperation("首页新闻列表查询")
    public RWapper newsListByCategoryAndPage(
            @PathVariable int columnId
            , @PathVariable int pageSize
            , @PathVariable int pageIndex) {
        List<NewsEntity> newsList = newsService.newsListByCategoryAndPage(columnId, pageSize, pageIndex);
        return RWapper.ok().put("page", newsList).encode(isEncryption);
    }

    /**
     * 首页新闻列表分页查询
     *
     * @param columnId  新闻栏目标识
     * @param pageSize  页大小
     * @param pageIndex 页码（从1开始计数）
     */
    @PostMapping("/newsPagedList/{columnId}/{pageSize}/{pageIndex}")
    //@ApiOperation("首页新闻列表分页查询")
    public RWapper newsPagedListByCategory(
            @PathVariable int columnId
            , @PathVariable int pageSize
            , @PathVariable int pageIndex) {
        PageUtils pagedList = newsService.newsPagedListByCategory(columnId, pageSize, pageIndex);
        return RWapper.ok().put("page", pagedList).encode(isEncryption);
    }

    /**
     * 首页轮播图片新闻查询
     */
    @PostMapping("/marqueePictureNewsList")
    //@ApiOperation("首页轮播图片新闻查询")
    public RWapper marqueePictureNewsList() {
        List<NewsEntity> newsList = newsService.marqueePictureNewsList();
        return RWapper.ok().put("page", newsList).encode(isEncryption);
    }

    /**
     * 获取新闻详细内容
     *
     * @param id 新闻标识
     */
    @CrossOrigin
    @PostMapping("/detail/{id}")
    //@ApiOperation("获取新闻详细内容")
    public RWapper getNewsDetailById(@PathVariable int id) {
        NewsEntity news = newsService.getNewsDetailById(id);
        if (news == null)
            return RWapper.error("该新闻不存在");

        if (news.getAuthorType() != null) {
            if (news.getAuthorType() == 1) {
                news.setAuthorFrontUser(null);
            } else if (news.getAuthorType() == 2) {
                news.setAuthorSysUser(null);
            }
        }

        Integer viewCount = Optional.ofNullable(news.getPageView()).orElse(0);
        news.setPageView(viewCount + 1);
        newsService.updateById(news);

        return RWapper.ok().put("info", news).encode(isEncryption);
    }

    /**
     * 获取指定新闻指定用户是否点赞
     *
     * @param newsId 新闻标识
     * @param userId 用户标识
     */
    @PostMapping("/isGivenGreats/{newsId}/{userId}")
    //@ApiOperation("获取指定新闻指定用户是否点赞")
    public RWapper getNewsIsGivenGreats(
            @PathVariable int newsId,
            @PathVariable int userId) {
        boolean result = newsService.getNewsIsGivenGreats(newsId, userId);
        return RWapper.ok().put("result", result).encode(isEncryption);
    }

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("list")
    //@ApiOperation("新闻列表(知识科普/我的发布)")
    public RWapper list(@ApiParam(value = "{\"newsColumn\":newsColumn," +
            "\"isMy\":false-知识科普等,true-我的发布,\"newsStatus\":(空串-全部,1-待审核,2-审核通过,3-不通过，4-删除),\"corporationId\",1")
                        @RequestBody Map<String, Object> params) {
        params.put("userId", getUserIdByTokenWithoutValidate());
        PageUtils page = newsService.selectNewsPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * APP首页：单独查询公告、资讯、活动
     */
    @PostMapping("noticeList")
    //@ApiOperation("公告、资讯、活动")
    public RWapper noticeList(@ApiParam(value = "{\"newsColumnValue\":\"pub-公告,activity-活动,info-资讯\"}")
                              @RequestBody Map<String, Object> params) {
        PageUtils page = newsService.selectNoticePage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @PostMapping("info/{id}/{userId}/{markType}")
    //@ApiOperation("新闻详情")
    public RWapper info(@PathVariable("id") Long id, @PathVariable("userId") Long userId, @PathVariable("markType") Long marktype) {
        Map param = new HashedMap();
        param.put("id", id);
        param.put("userId", userId);
        param.put("marktype", marktype);
        Map news = newsService.newsDetail(param);

        if (news == null) {
            return RWapper.error("新闻不存在").encode(isEncryption);
        }
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setId((int) news.get("id"));
        newsEntity.setPageView((int) news.get("pageView") + 1);
        newsService.updateById(newsEntity);
        if (news.get("activityEndTime") != null && !"".equals(news.get("activityEndTime"))) {
            try {
                long endTime = DateUtils.parseDate(news.get("activityEndTime").toString(), new String[]{"yyyy-MM-dd HH:mm"}).getTime();

                if (endTime < System.currentTimeMillis()) {
                    news.put("isJoinIn", false);
                } else {
                    news.put("isJoinIn", true);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return RWapper.ok().put("news", news).encode(isEncryption);
    }

    @PostMapping("save")
    //@ApiOperation("添加新闻")
    public RWapper save(@RequestBody NewsEntity newsEntity) {
        //社团待审核
        CorporationEntity corporationEntity = corporationService.selectById(newsEntity.getCorporationId());
        if (corporationEntity == null) {
            throw new RRException(ResultEnum.CORPORATION_NOT_EXIST);
        }
        if (corporationEntity.getCorporationStatus() != Constant.STATUS_PASS) {
            throw new RRException(ResultEnum.UNPASS_CORPORATION_CANT_SUBMIT);
        }
        newsEntity.setNewsAuthor(getUserIdByToken());
        newsEntity.setPageView(0);//点击数
        newsEntity.setAuthorType(2);//用户类型
        newsEntity.setNewsCreateTime(new Date());
        newsEntity.setNewsUpdateTime(new Date());
        newsEntity.setNewsStatus(NEWS_STATUS_AUDITING);
        newsService.insert(newsEntity);
        return RWapper.ok();
    }

    /**
     * 修改
     */
    @Login
    @PostMapping("update")
    //@ApiOperation("修改")
    public RWapper update(@RequestBody NewsEntity news) throws IOException {
        //社团待审核
        CorporationEntity corporationEntity = corporationService.selectById(news.getCorporationId());
        if (corporationEntity == null) {
            throw new RRException(ResultEnum.CORPORATION_NOT_EXIST);
        }
        if (corporationEntity.getCorporationStatus() != Constant.STATUS_PASS) {
            throw new RRException(ResultEnum.UNPASS_CORPORATION_CANT_MODIFY);
        }
        news.setNewsStatus(Constant.NEWS_STATUS_AUDIT);
        newsService.updateById(news);
        //社团负责人发布的内容不需要更改索引
//        Map param = new HashedMap();
//        param.put("id", news.getId());
//        Map newsDetail = newsService.newsDetail(param);
//
//        //修改编程待审核状态,删除索引
//        IndexCategory indexCategory
//                = IndexCategory.matchCategory(TableName.NEWS, news.getNewsColumn());
//        LuceneUtils.deleteIndexItem(indexCategory, news.getId());
        return RWapper.ok();
    }

    /*
     * 删除
     */
    @Login
    @PostMapping("/delete/{id}")
    //@ApiOperation("删除")
    public RWapper delete(@PathVariable("id") int id) throws IOException {
        long userid = getUserIdByToken();
        NewsEntity entity = new NewsEntity();
        entity.setNewsAuthor(userid);
        entity.setId(id);
        entity = newsService.selectOne(new EntityWrapper<>(entity));
        if (entity == null) {
            return RWapper.error("新闻不存在");
        }
        //社团待审核
        CorporationEntity corporationEntity = corporationService.selectById(entity.getCorporationId());
        if (corporationEntity == null) {
            throw new RRException(ResultEnum.CORPORATION_NOT_EXIST);
        }
        if (corporationEntity.getCorporationStatus() != Constant.STATUS_PASS) {
            throw new RRException(ResultEnum.UNPASS_CORPORATION_CANT_SUBMIT);
        }
        newsService.delete(new EntityWrapper<>(entity));
        //删除消息
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
        messageRecordEntity.setMessageTabType(1);//文章
        messageRecordEntity.setRecordId(id);
        messageRecordService.delete(new EntityWrapper<>(messageRecordEntity));

        //社团负责人发布的内容不需要删除索引
//        IndexCategory indexCategory
//                = IndexCategory.matchCategory(TableName.NEWS, entity.getNewsColumn());
//        LuceneUtils.deleteIndexItem(indexCategory, entity.getId());
        return RWapper.ok();
    }
}
