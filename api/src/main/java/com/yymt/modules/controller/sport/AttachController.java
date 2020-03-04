package com.yymt.modules.controller.sport;

import com.yymt.annotation.Login;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 附件管理
 * <p>
 * Created by 13 on 2017/2/21.
 */
@RestController
@RequestMapping("attach")
@Api(tags = "文件上传接口")
public class AttachController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachController.class);

    @Value("${web.upload.path}")
    private String path;
    /**
     * 上传文件接口
     * @return
     */
    @Login
    @PostMapping("upload")
    @ApiOperation(value = "上传文件",notes = "最大上传文件50M")
    public RWapper upload(@RequestParam("file") MultipartFile[] multipartFiles) {
        String hostUrl = getTopUrl();
        RWapper result = ToolUtils.uploadImageFile(multipartFiles,path,hostUrl).encode(isEncryption);
        return result;
    }


    /**
     * 上传文件接口
     * @return
     */
    @Login
    @PostMapping("uploadImageBase64Data")
    @ApiOperation(value = "上传文件",notes = "最大上传文件50M")
    public RWapper uploadImageData(@RequestBody Map<String,Object> data) {
        if(data.get("imageData") == null){
            return RWapper.error("图片数据为空");
        }
        String hostUrl = getTopUrl();
        String imageData = (String) data.get("imageData");
        MultipartFile imageMultipartFile = ToolUtils.base64ToMultipart(imageData);
        RWapper result = ToolUtils.uploadImageFile(new MultipartFile[]{imageMultipartFile},path,hostUrl).encode(isEncryption);
        return result;
    }



    /**
     *
     * @param request
     * @param multipartFiles
     * @return
     */
    @Login
    @PostMapping(value = "uploadMediaFile")
    @ApiOperation(value = "上传音频文件",notes = "最大上传文件30M")
    public R uploadMediaFile(@RequestParam("file") MultipartFile[] multipartFiles) {
        // 定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<>();
//        extMap.put("image", "gif,jpg,jpeg,png,bmp");
//        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,mp4,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
//        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

        // 最大文件大小 100M
        Integer maxSize = Constant.MAX_SOUND_FILE_SIZE;

//        String dirName = request.getParameter("dir");
//        if (dirName == null) {
//            dirName = "image";
//        }
//        if (!extMap.containsKey(dirName)){
//            return R.error(ResultEnum.UPLOAD_DIR_ERROR);
//        }
        // 创建文件夹
        String midPath = "/upload/sound" +  "/" + DateUtils.format(new Date(), "yyyyMMdd/");
        String savePath = path + midPath;

        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = multipartFile.getOriginalFilename();
            // 检查扩展名
            String fileExt = fileName.substring(
                    fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!Arrays.asList(extMap.get("media").split(","))
                    .contains(fileExt)) {
                return R.error().put("error", 1).put("message", "上传文件类型错误。\n只允许"+ extMap.get("media") + "格式。");
            }
            if (multipartFile.getSize() <= maxSize) {
                String fileUrl = null;
                try {
                        fileUrl = ToolUtils.uploadFileStr(multipartFile.getBytes(),path,midPath, fileName,getTopUrl());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return R.ok().put("error", 0).put("url",fileUrl);
            } else {
                return R.error(ResultEnum.UPLOAD_FILE_SIZE_LIMIT);
            }
        }
        return R.ok();
    }

    @Login
    @PostMapping(value = "delete")
    @ApiOperation("删除文件")
    public R delete(@RequestParam String fileUrl) {
        R result = ToolUtils.deleteFile(path,fileUrl);
        return result;
    }

}
