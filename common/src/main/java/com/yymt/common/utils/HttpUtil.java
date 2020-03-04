package com.yymt.common.utils;

import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.List;
import java.util.Map;

/**
 * http请求工具
 */
public class HttpUtil
{
	
	private final static Logger log= Logger.getLogger(HttpUtil.class);

	/**
	 * post请求，不加代理
	 * @param url 功能和操作
	 * @param body  要post的数据
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, String body) {
		return post(url,body,false,null,null);
	}

    /**
	 * post请求
	 *
	 * @param url
	 *            功能和操作
	 * @param body
	 *            要post的数据
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, String body,boolean isproxy,String proxyHost,Integer proxyPort){
		String result = "";
		try{
			OutputStreamWriter out = null;
			BufferedReader in = null;
			URL realUrl = new URL(url);
//			URLConnection conn = realUrl.openConnection();
            URLConnection conn = null;
            if(isproxy){//使用代理模式
                log.info("-------------使用代理模式");
                @SuppressWarnings("static-access")
                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            }else{
                log.info("-------------不使用代理");
                conn = (HttpURLConnection) realUrl.openConnection();
            }
			// 设置连接参数
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(20000);

			// 提交数据
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(body);
			out.flush();

			// 读取返回数据
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			boolean firstLine = true; // 读第一行不加换行符
			while ((line = in.readLine()) != null)
			{
				if (firstLine)
				{
					firstLine = false;
				} else
				{
					result += System.lineSeparator();
				}
				result += line;
			}
		} catch (Exception e){
			e.printStackTrace();
            log.error("\n"+e.getClass().getName()+":"+e.getMessage()+"\n");
			throw new RRException(ResultEnum.ERROR);
		}
		return result;
	}
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            log.error("\n"+e.getClass().getName()+":"+e.getMessage()+"\n");
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(Map<String,Object> requestProperty,String url, String param,boolean isproxy,String proxyHost,Integer proxyPort)throws Exception {

        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
//        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = null;//realUrl.openConnection();
            if(isproxy){//使用代理模式
                @SuppressWarnings("static-access")
                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            }else{
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

        for (String key: requestProperty.keySet() ) {
            conn.setRequestProperty(key,requestProperty.get(key).toString());
        }
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn
                .getOutputStream(), "UTF-8");
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
//        }
        return result;
    }
	
    /**
     * 重载sendPost，不使用代理
     * @param requestProperty
     * @param url
     * @param param
     * @return
     */
    public static String sendPost(Map<String,Object> requestProperty,String url, String param) throws Exception{
    	return sendPost(requestProperty,url, param,false,null,null);
    }

    /**
     * 发送http delete请求
     */
    public static R httpDelete(String url,Map<String,String> headers,boolean isproxy,String proxyHost,Integer proxyPort){

        String content = null;
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();
        //since 4.3 不再使用 DefaultHttpClient
        CloseableHttpClient closeableHttpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
        HttpDelete httpdelete = new HttpDelete(url);

        if(isproxy) {
            RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
                    .setProxy(new HttpHost(proxyHost, proxyPort))
                    .build();
            httpdelete.setConfig(requestConfig);
        }
        //设置header
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpdelete.setHeader(entry.getKey(),entry.getValue());
            }
        }
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = closeableHttpClient.execute(httpdelete);
            HttpEntity entity = httpResponse.getEntity();
            System.out.println("-------------"+httpResponse.getStatusLine());
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                return R.ok();
            }else{
                return R.error("调用接口失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {   //关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.error();
    }


}