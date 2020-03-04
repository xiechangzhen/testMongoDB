package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.NewsEntity;
import com.yymt.entity.sport.NewsGreatsEntity;
import com.yymt.service.MessageRecordService;
import com.yymt.service.NewsGreatsService;
import com.yymt.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

import static com.yymt.common.utils.Constant.*;


/**
 * 新闻点赞表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@RestController
@RequestMapping("/newsgreats")
//@Api(tags = "新闻点赞")
public class NewsGreatsController extends BaseController {
    @Autowired
    private NewsGreatsService newsGreatsService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageRecordService messageRecordService;

    /**
     * 列表
     */
    @PostMapping("list")
    //@ApiOperation("点赞列表")
    public RWapper list(@RequestBody Map<String, Object> params) {
        if (params.get("newsId") == null) {
            throw new RRException(ResultEnum.NEWS_ID_NOT_EXIST);
        }
        PageUtils page = newsGreatsService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:newsgreats:info")
    public RWapper info(@PathVariable("id") Long id) {
        NewsGreatsEntity newsGreats = newsGreatsService.selectById(id);

        return RWapper.ok().put("newsGreats", newsGreats).encode(isEncryption);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    //@ApiOperation("点赞")
    @Transactional(rollbackFor = Exception.class)
    public RWapper save(@RequestBody NewsGreatsEntity newsGreats) {
        Integer newsId = newsGreats.getNewsId();
        int newsCount = newsService.selectCount(
                new EntityWrapper<NewsEntity>().eq("id", newsId));
        if (newsCount < 1)
            return RWapper.error("新闻不存在");

        int count = 0;
        newsGreats.setUserId(getUserIdByToken());
        NewsGreatsEntity queryEntity = newsGreatsService.selectOne(new EntityWrapper<>(newsGreats));
        if (queryEntity != null) {
            newsGreatsService.delete(new EntityWrapper<>(queryEntity));
            count = newsGreatsService.queryGreatCountByNewsId(newsGreats.getNewsId());
            return RWapper.ok().put("totalGreat", count).encode(isEncryption);
        } else {
            newsGreats.setGreatsTime(new Date());
            newsGreatsService.insert(newsGreats);
            NewsEntity newsEntity = newsService.selectById(newsGreats.getNewsId());
            if (newsEntity != null && newsEntity.getAuthorType() != 1) {//后台用户添加的不需要消息
                messageRecordService.insertMsg(newsGreats.getUserId(), newsEntity.getNewsAuthor(),
                        MESSAGE_TYPE_MSG, MESSAGE_TAB_GREATS, MESSAGE_TAB_TYPE_GREATS_NEWS, "点赞了你的文章", newsEntity.getId());
            }
            count = newsGreatsService.queryGreatCountByNewsId(newsGreats.getNewsId());
            return RWapper.ok().put("totalGreat", count).encode(isEncryption);
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:newsgreats:update")
    public RWapper update(@RequestBody NewsGreatsEntity newsGreats) {
        newsGreatsService.updateById(newsGreats);
        return RWapper.ok();
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("delete/{id}")
    public RWapper delete(@PathVariable("id") int id) {
        NewsGreatsEntity entity = new NewsGreatsEntity();
        entity.setNewsId(id);
        entity.setUserId(getUserIdByToken());
        newsGreatsService.cancelGreat(entity);
        int count = newsGreatsService.queryGreatCountByNewsId(id);
        return RWapper.ok().put("totalGreat", count).encode(isEncryption);
    }

    /**
     * 点赞的新闻
     */
    @Login
    @PostMapping("like")
    //@ApiOperation("喜欢的新闻")
    public RWapper like(@ApiParam("{\"isFriend\":true(查询（粉丝或者关注）喜欢false(查询自己),\"friendId\":11}") @RequestBody Map<String, Object> params) {
        Long userId = getUserIdByTokenWithoutValidate();
        params.put("userId", userId);
        PageUtils page = newsGreatsService.like(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }
}
