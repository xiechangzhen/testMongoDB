package com.yymt.common.utils;

import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
//import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

/**
 * 常用工具类
 * Created by yymt_hgq on 2018/2/10.
 */
public class ToolUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToolUtils.class);

    /**
　　　* BASE64加密工具
　　*/
    public static String encryptBASE64(String str){
        byte[] key = str.getBytes();
        try{
            return org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(key);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("BASE64编码失败!");
        }
    }

    public static MultipartFile base64ToMultipart(String base64) {
        String[] baseStrs = base64.split(",");
        Base64.Decoder decoder = Base64.getDecoder();
//            BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = new byte[0];
        b = decoder.decode(baseStrs[1]);

        for(int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        return new BASE64DecodedMultipartFile(b, baseStrs[0]);
    }

    /**
     * 保存文件
     * @param multipartFiles 上传的文件
     * @param hostUrl 返回url的头路径
     * @param path 保存的物理路径的头部
     * @return
     */
    public static RWapper uploadImageFile(MultipartFile[] multipartFiles,String path,String hostUrl) {
        java.util.List<String> errorFiles = new ArrayList<>();
        java.util.List<Map<String,String>> uploadFiles = new ArrayList<>();
        String prefix = "/upload/" + DateUtils.format(new Date(), "yyyyMMdd/");
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String fileName = multipartFile.getOriginalFilename();
                if (multipartFile.getSize() <= Constant.MAX_FILE_SIZE) {
                   String fileUrl = uploadImageFile(multipartFile.getBytes(),path,prefix, fileName,hostUrl);
                   Map<String,String> data = new HashMap<>();
                    data.put("fileUrl",fileUrl);
                    uploadFiles.add(data);
                } else {
                    throw new RRException(ResultEnum.UPLOAD_FILE_SIZE_LIMIT);
                    //errorFiles.add(fileName);
                }
            }
        } catch (Exception e) {
            LOGGER.error("上传文件失败",e);
            throw new RRException(ResultEnum.UPLOAD_ERROR);
        }
        return RWapper.ok().put("uploadFiles",uploadFiles).put("errorFiles",errorFiles);
    }

    /**
     * 保存文件
     * @param multipartFiles 上传的文件
     * @param hostUrl 返回url的头路径
     * @param path 保存的物理路径的头部
     * @return
     */
    public static R uploadFile(MultipartFile[] multipartFiles,String path,String hostUrl) {
        java.util.List<String> errorFiles = new ArrayList<>();
        java.util.List<Map<String,String>> uploadFiles = new ArrayList<>();
        String prefix = "/upload/" + DateUtils.format(new Date(), "yyyyMMdd/");
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String fileName = multipartFile.getOriginalFilename();
                if (multipartFile.getSize() <= Constant.MAX_FILE_SIZE) {
                        Map<String,String> fileUrl = uploadFile(multipartFile.getBytes(),path,prefix, fileName,hostUrl);
                        uploadFiles.add(fileUrl);
                } else {
                    errorFiles.add(fileName);
                }
            }
        } catch (Exception e) {
            LOGGER.error("上传文件失败",e);
            throw new RRException(ResultEnum.UPLOAD_ERROR);
        }
        return R.ok().put("uploadFiles",uploadFiles).put("errorFiles",errorFiles);
    }

    /**
     * 保存文件
     * @param file 文件
     * @param topPath 保存的物理路径的头部
     * @param fileName 文件名
     * @param hostUrl 返回url的头路径
     * @return
     */
    public static Map<String,String> uploadFile(byte[] file, String topPath,String prefix, String fileName,String hostUrl) {
        Map<String,String> map = new HashMap<>();
        String fileUrl = uploadFileStr(file,topPath,prefix,fileName,hostUrl);
        map.put("fileUrl",fileUrl);
        return map;
    }



    /**
     * 保存文件
     * @param file 文件
     * @param topPath 保存的物理路径的头部
     * @param fileName 文件名
     * @param hostUrl 返回url的头路径
     * @return
     */
    public static String uploadFileStr(byte[] file, String topPath,String prefix, String fileName,String hostUrl) {
        String name = renameFile(fileName);
        FileOutputStream out = null;
        try {
            String filePath = topPath+prefix;
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            out = new FileOutputStream(filePath+name);
            out.write(file);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException(ResultEnum.UPLOAD_ERROR);
        }
        finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hostUrl+prefix+name;
    }

    /**
     *
     * @param file
     * @param topPath
     * @param prefix
     * @param fileName
     * @param hostUrl
     * @return
     */
    public static String uploadImageFile(byte[] file, String topPath,String prefix, String fileName,String hostUrl) {
        String name = renameFile(fileName);
        FileOutputStream out = null;
        try {
            String filePath = topPath+prefix;
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            out = new FileOutputStream(filePath+name);
            float quality = (1024*1024f) / file.length;
            BufferedImage bi1 = ImageIO.read(new ByteArrayInputStream(file));
            int width = bi1.getWidth() >= 540?540:bi1.getWidth();
            Thumbnails.of(new ByteArrayInputStream(file)).width(width).outputQuality(quality>1?1f:quality).toOutputStream(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException(ResultEnum.UPLOAD_ERROR);
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hostUrl+prefix+name;
    }

    public static R deleteFile(String path,String fileUrl){
        try {
            new File(path + fileUrl).delete();
        } catch (Exception e) {
            String msg = "文件删除失败";
            LOGGER.error(msg, e);
            return R.error(ResultEnum.DELETE_ERROR);
        }
        return R.ok();
    }
    /**
     * rename file to uuid
     * @param fileName
     * @return
     */
    public static String renameFile(String fileName){
        String name = StringUtils.trimToNull(fileName);
        if (name == null) {
            name = UUID.randomUUID() + "." + null;
        } else {
            name = name.replace('\\', '/');
            name = name.substring(name.lastIndexOf("/") + 1);
            int index = name.lastIndexOf(".");
            String ext = null;
            if (index >= 0) {
                ext = StringUtils.trimToNull(name.substring(index + 1));
            }
            name = UUID.randomUUID() + "." + (ext == null ? null : (ext));
        }
        return name;
    }

    /**
     * 判断文件是否是图片类型
     *
     * @param imageFile
     * @return
     */
    public static boolean isImage(InputStream imageFile) {
        try {
            Image img = ImageIO.read(imageFile);
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取保存文件的位置,jar所在目录的路径
     *
     * @return
     */
    public static String getUplodFilePath() {
        String path = ToolUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(1, path.length());
        try {
            path = java.net.URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int lastIndex = path.lastIndexOf("/") + 1;
        path = path.substring(0, lastIndex);
        File file = new File("");
        return file.getAbsolutePath() + "/";
    }

}
