package com.yymt.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @describe:转换工具类
 * @author xiaojin
 * @date 2020年02月07日 上午9:49:05
 **/
public class ConvertUtil {

	/**
	 * 
	 * @describe:获取上传路径
	 * @author: xiaojin
	 */
	public static String getUploadPath() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		return "upload/" + year + "/" + month + "/";
	}

	public static List<String> getImgSrc(String htmlStr) {
		if (htmlStr == null) {
			return null;
		}
		String img = "";
		Pattern p_image;
		java.util.regex.Matcher m_image;
		List<String> pics = new ArrayList<String>();

		String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr);
		while (m_image.find()) {
			img = img + "," + m_image.group();
			// Matcher m =
			// Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //匹配src
			java.util.regex.Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while (m.find()) {
				pics.add(m.group(1));
			}
		}
		return pics;
	}

	public static void deleteFile(String uploadPath, String filePath) {
		File file = new File(uploadPath + filePath);
		file.delete();
	}

	
	public static Map<String, Object> getPageParams(Map<String, Object> params) {
		Object pageSizeObj = params.get("pageSize");
		Object currPageObj = params.get("currPage");
		int currPage = 1;
		int pageSize=10;
		if(pageSizeObj != null){
			pageSize=Integer.parseInt(String.valueOf(pageSizeObj));
		}
		if(currPageObj != null){
			currPage=Integer.parseInt(String.valueOf(currPageObj));
		}
		
		params.put("index", (currPage - 1) * pageSize);
		params.put("pageSize", pageSize);
		params.put("currPage", currPage);
		return params;
	}
	
	
	public static PageUtils getPageUtil(Map<String, Object> params, List<Map<String, Object>> list, int count) {
		int pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));
		int currPage = Integer.parseInt(String.valueOf(params.get("currPage")));
		PageUtils page = new PageUtils(list, count, pageSize, currPage);
		return page;
	}
	
	
	/**
	 * String转换工具类：包含null对象，空字符串大小写"null"，空格，统一转成 ：null对象
	 */
	public static String objToStrConverNull(Object object) {
		String string = null;
		if (object == null) {
			return string;
		} else {
			string = String.valueOf(object).trim();
			if (string.length() == 0 || string.equalsIgnoreCase("null")) {
				return null;
			}
			return string;
		}
	}
	
	/**
	 * String转换工具类：包含null对象，空字符串大小写"null"，空格，统一转成 ：""对象
	 */
	public static String objToStrConverSpace(Object object) {
		String string = "";
		if (object == null) {
			return string;
		} else {
			string = String.valueOf(object).trim();
			if (string.length() == 0 || string.equalsIgnoreCase("null")) {
				return "";
			}
			return string;
		}
	}
	
	
	public static int parseInt(Object object) {
		String string = objToStrConverNull(object);
		Integer integer = 0;
		if (string != null) {
			integer = Integer.parseInt(string);
		}
		return integer;
	}
	
	
	public static long parseLong(Object object) {
		String string = objToStrConverNull(object);
		long l = 0;
		if (string != null) {
			l = Long.parseLong(string);
		}
		return l;
	}
	
}
