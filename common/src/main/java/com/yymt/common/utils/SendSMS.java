package com.yymt.common.utils;

import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信邮验证码通知短信接口
 * 
 * @ClassName: IndustryEmailSMS
 * @Description: 短信邮验证码通知短信接口
 *
 */
public class SendSMS{

	private static Logger logger = LoggerFactory.getLogger(SendSMS.class);
	/**
	 * 短信验证码通知短信
	 * 不使用http代理
	 */
	public static Map<String, Object> sendSMS(String phone,String url,String accountSid,String authToken){
		return sendSMS(phone,url,accountSid,authToken,false,null,null);
	}
	/**
	 * 短信验证码通知短信
	 */
	public static Map<String, Object> sendSMS(String phone,String url,String accountSid,String authToken,boolean isProxy,String proxyHost,Integer proxyPort){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try{
			String vcode = createRandomVcode();
			String smsContent = "【智慧体育】您的验证码为"+vcode+"，请于15分钟内正确输入，如非本人操作，请忽略此短信。";
			String body = "accountSid=" + accountSid
					+ "&to=" + phone
					+ "&smsContent=" + smsContent
					+ createCommonParam(accountSid,authToken);

			// 提交请求
//			boolean isproxy = Boolean.parseBoolean(PortConfig.getValue("isproxy"));
//			int proxyPort = Integer.parseInt(PortConfig.getValue("proxyPort"));
//			String result = HttpUtil.post(url, body,isproxy,PortConfig.getValue("proxyHost"),proxyPort);
			String result = null;

			if(isProxy){//使用http代理
				logger.info("代理信息：isProxy"+isProxy+"\t"+proxyHost+"\t"+proxyPort);
				result = HttpUtil.post(url,body,isProxy,proxyHost,proxyPort);
			}else {
				result = HttpUtil.post(url, body);
			}
//			result = "{\"respCode\":\"00000\"}";
			JSONObject jsonObject=JSONObject.fromObject(result);
			resultMap.put("vcode", vcode);
			resultMap.put("resultCode", jsonObject.get("respCode"));
			logger.info("result:" + System.lineSeparator() + result);
		}catch(Exception e){
			e.printStackTrace();
			throw new RRException(ResultEnum.ERROR);
		}
		return resultMap;
	}
	
	/**
	 * 6位随机数验证码
	 */
    private static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
	/**
	 * 构造通用参数timestamp、sig和respDataType
	 */
	private static String createCommonParam(String accountSid,String authToken){
		// 时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		// 签名
		String sig = DigestUtils.md5Hex(accountSid + authToken + timestamp);
		return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=json";
	}
}
