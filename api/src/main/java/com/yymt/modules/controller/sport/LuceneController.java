package com.yymt.modules.controller.sport;

import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.HttpContextUtils;
import com.yymt.common.utils.R;
import com.yymt.entity.api.IndexCategory;
import com.yymt.search.LuceneUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 描述:${DESCRIPTION}
 * 作者:Administrator
 * 时间:2018-03-31 9:56
 **/
@RestController
@RequestMapping("/lucene")
//@Api(tags = "Lucene数据接口，正式环境不显示")
public class LuceneController {

    @Value("${server.port}")
    String port;
    @Value("${server.context-path}")
    String path;


    @PostMapping("save")
    //@ApiOperation("save")
    public R save(@RequestBody Map<String, Object> data) throws IOException {
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        String localRequest = "http://localhost:" + port + path + "/lucene/save";
        StringBuffer sb = httpServletRequest.getRequestURL();
        if (localRequest.equals(sb.toString())) {
            IndexCategory indexCategory;
            Object categoryObj = data.get("category");
            try {
                indexCategory = (IndexCategory) categoryObj;
            } catch (Exception e) {
                indexCategory = Enum.valueOf(IndexCategory.class, categoryObj.toString());
            }
            Integer id = Integer.parseInt(data.get("id").toString());
            String titleData = data.get("title").toString();
            String contentData = data.get("content").toString();
            LuceneUtils.indexItem(indexCategory, id, titleData, contentData);
            return R.ok();
        } else {
            return R.error(ResultEnum.NO_IMPLEMENT);
        }
    }

    @PostMapping("update")
    //@ApiOperation("update")
    public R update(@RequestBody Map<String, Object> data) throws IOException {
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        String localRequest = "http://localhost:" + port + path + "/lucene/update";
        StringBuffer sb = httpServletRequest.getRequestURL();
        if (localRequest.equals(sb.toString())) {
            IndexCategory indexCategory;
            Object categoryObj = data.get("category");
            try {
                indexCategory = (IndexCategory) categoryObj;
            } catch (Exception e) {
                indexCategory = Enum.valueOf(IndexCategory.class, categoryObj.toString());
            }
            Integer id = Integer.parseInt(data.get("id").toString());
            String titleData = data.get("title").toString();
            String contentData = data.get("content").toString();

            LuceneUtils.updateIndexItem(indexCategory, id, titleData, contentData);
            return R.ok();
        } else {
            return R.error(ResultEnum.NO_IMPLEMENT);
        }
    }

    @PostMapping("delete")
    //@ApiOperation("delete")
    public R delete(@RequestBody Map<String, Object> data) throws IOException {
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        String localRequest = "http://localhost:" + port + path + "/lucene/delete";
        StringBuffer sb = httpServletRequest.getRequestURL();
        if (localRequest.equals(sb.toString())) {
            IndexCategory indexCategory;
            Object cgObj = data.get("category");
            try {
                indexCategory = (IndexCategory) cgObj;
            } catch (Exception e) {
                indexCategory = Enum.valueOf(IndexCategory.class, cgObj.toString());
            }
            Integer id = (Integer) data.get("id");

            LuceneUtils.deleteIndexItem(indexCategory, id);
            return R.ok();
        } else {
            return R.error(ResultEnum.NO_IMPLEMENT);
        }
    }
}
