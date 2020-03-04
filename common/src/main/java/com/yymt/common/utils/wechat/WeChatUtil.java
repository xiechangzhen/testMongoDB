package com.yymt.common.utils.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yymt.common.utils.ConvertUtil;

import net.sf.json.JSONObject;

/**
 * 
 * @describe：微信工具类
 */
public class WeChatUtil {
	public static Log log = LogFactory.getLog(WeChatUtil.class);

	/**
	 * 开发者ID(AppID)
	 */
	public static String WECHAT_APPID = "wxdf49d567997f26c9";

	/**
	 * 开发者密码(AppSecret)
	 */
	public static String WECHAT_APPSECRET = "5aa4df41aa045cdd1d3aa34cac996a2f";

	/**
	 * API密钥
	 */
	public static String KEY = "1qaz3edc5tgb7ujm9ol0p2wsx4rfv6yh";

	/**
	 * 微信商户id
	 */
	public static String MCH_ID = "1553279771";

	// /**
	// * 回调通知url地址
	// */
	// public static String NOTIFY_URL = "http://cyly.jxzjyly.com:4521/";

	// 测试用
	// public static String NOTIFY_URL = "http://cyly.frp.zeroingin.cn/";

	public static String TICKET_URL = "http://mp.weixin.qq.com?params=value";

	/**
	 * 内存中的token
	 */
	public static String WECHAT_TOKEN = null;

	/**
	 * 内存中的token最后一次请求时间
	 */
	public static Date WECHAT_LASTDATE = null;

	/**
	 * 内存中的ticket
	 */
	public static String TICKET = null;

	/**
	 * 内存中的ticket最后一次请求时间
	 */
	public static Date TICKET_LASTDATE = null;

	public static final String HMACSHA256 = "HMACSHA256";

	public static final String MD5 = "MD5";

	public static final String SUCC_RESULT_XML = "<xml>\r\n" + "  <return_code><![CDATA[SUCCESS]]></return_code>\r\n"
			+ "  <return_msg><![CDATA[OK]]></return_msg>\r\n" + "</xml>";

	/**
	 * 内存中通过code换取网页授权access_token
	 */
	public static String ACCESS_TOKEN = null;

	/**
	 * 内存中通过code换取网页授权access_token的最后一次请求时间
	 */
	public static Date TOKEN_LASTDATE = null;

	public static String getNetWorkConnection(String requestUrl, String requestMethod, String output) {
		StringBuffer buffer = null;
		try {
			URL url = new URL(requestUrl);
			if (url.getProtocol().toLowerCase().equals("https")) {
				HttpsURLConnection connections = null;
				connections = (HttpsURLConnection) url.openConnection();
				connections.setDoOutput(true);
				connections.setDoInput(true);
				connections.setUseCaches(false);
				connections.setRequestMethod(requestMethod);
				if (null != output) {
					OutputStream outputStream = connections.getOutputStream();
					outputStream.write(output.getBytes("UTF-8"));
					outputStream.close();
				}

				// 从输入流读取返回内容
				InputStream inputStream = connections.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String str = null;
				buffer = new StringBuffer();
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
				inputStream = null;
				connections.disconnect();
			} else {
				HttpURLConnection connection = null;
				connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setUseCaches(false);
				connection.setRequestMethod(requestMethod);
				if (null != output) {
					OutputStream outputStream = connection.getOutputStream();
					outputStream.write(output.getBytes("UTF-8"));
					outputStream.close();
				}

				// 从输入流读取返回内容
				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String str = null;
				buffer = new StringBuffer();
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
				inputStream = null;
				connection.disconnect();
			}
			// HttpsURLConnection connection = (HttpsURLConnection)
			// url.openConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = buffer.toString();
		log.info("=====请求地址========" + requestUrl);
		log.info("=====请求方式========" + requestMethod);
		if (output != null) {
			log.info("=====POST请求数据====" + output);
		}
		log.info("=====返回数据========" + result);
		return result;
	}

	public static String getNetWorkConnectionForPost(String requestUrl, String output) {
		return getNetWorkConnection(requestUrl, "POST", output);
	}

	public static String getNetWorkConnectionForGet(String requestUrl) {
		return getNetWorkConnection(requestUrl, "GET", null);
	}

	/**
	 * @describe：获取access_token
	 */
	public static String getAccessToken() {
		if (WECHAT_TOKEN != null && WECHAT_LASTDATE.getTime() + 1000 * 60 * 60 * 2 > new Date().getTime()) {
			return WECHAT_TOKEN;
		} else {
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WECHAT_APPID
					+ "&secret=" + WECHAT_APPSECRET;
			String accessToken = getNetWorkConnectionForGet(url);
			WECHAT_TOKEN = String.valueOf(JSONObject.fromObject(accessToken).get("access_token"));
			WECHAT_LASTDATE = new Date();
			return WECHAT_TOKEN;
		}
	}

	/**
	 * 通过code换取网页授权access_token
	 * 
	 * @param code
	 * @return
	 */
	public static Map<String, Object> getSnsapiUserInfo(String code) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WECHAT_APPID + "&secret="
				+ WECHAT_APPSECRET + "&code=" + code + "&grant_type=authorization_code";
		String data = getNetWorkConnectionForGet(url);
		JSONObject jsonObject = JSONObject.fromObject(data);
		String errcode = ConvertUtil.objToStrConverNull(jsonObject.get("errcode"));
		if (errcode == null) {
			String openId = "";
			String access_token  = String.valueOf(jsonObject.get("access_token"));
			// TOKEN_LASTDATE = new Date();
			openId = ConvertUtil.objToStrConverNull(jsonObject.get("openid"));
			url = " https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openId
					+ "&lang=zh_CN";
			data = getNetWorkConnectionForGet(url);
			jsonObject = JSONObject.fromObject(data);
			errcode = ConvertUtil.objToStrConverNull(jsonObject.get("errcode"));
			if (errcode == null) {
				resultMap.put("errcode", 0);
				resultMap.put("userInfo", jsonObject);
				return resultMap;
			} else {
				resultMap.put("errcode", errcode);
				resultMap.put("errmsg", String.valueOf(jsonObject.get("errmsg")));
				return resultMap;
			}
		} else {
			resultMap.put("errcode", errcode);
			resultMap.put("errmsg", String.valueOf(jsonObject.get("errmsg")));
			return resultMap;
		}
	}
	

	/**
	 * @describe：获取微信公众号用户openID
	 */
	public static JSONObject getUserOpenId(String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&appid="
				+ WECHAT_APPID + "&secret=" + WECHAT_APPSECRET + "&code=" + code;
		String data = getNetWorkConnectionForGet(url);
		// String openId =
		// String.valueOf(JSONObject.fromObject(data).get("openid"));
		return JSONObject.fromObject(data);
	}

	/**
	 * @describe：根据openid获取用户基本信息
	 */
	public static JSONObject getUserInfo(String openid) {
		String access_token = getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + access_token + "&openid=" + openid
				+ "&lang=zh_CN";
		String data = getNetWorkConnectionForGet(url);
		return JSONObject.fromObject(data);
	}

	/**
	 * @describe：获得jsapi_ticket
	 */
	public static String getTicket() {
		if (TICKET != null && TICKET_LASTDATE.getTime() + 1000 * 60 * 60 * 2 > new Date().getTime()) {
			return TICKET;
		} else {
			String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + getAccessToken()
					+ "&type=jsapi";
			String accessToken = getNetWorkConnectionForGet(url);
			TICKET = String.valueOf(JSONObject.fromObject(accessToken).get("ticket"));
			TICKET_LASTDATE = new Date();
			return TICKET;
		}
	}

	/**
	 * 生成 MD5
	 *
	 * @param data
	 *            待处理数据
	 * @return MD5结果
	 */
	public static String MD5(String data) throws Exception {
		java.security.MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 生成 HMACSHA256
	 * 
	 * @param data
	 *            待处理数据
	 * @param key
	 *            密钥
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String HMACSHA256(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	public static String map2XmlString(Map<String, Object> map) {
		String xmlResult = "";
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		for (String key : map.keySet()) {
			String value = String.valueOf(map.get(key));
			sb.append("<" + key + ">" + value + "</" + key + ">");
		}
		sb.append("</xml>");
		xmlResult = sb.toString();
		return xmlResult;
	}

}
