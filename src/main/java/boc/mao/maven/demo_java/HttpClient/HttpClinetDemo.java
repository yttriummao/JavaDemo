package boc.mao.maven.demo_java.HttpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * @author 猪本聪
 * @time 2018年5月22日 - 上午10:02:08
 * 
 * 说明：
 */

public class HttpClinetDemo 
{
	public static void executeGet() throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet = new HttpGet("http://www.tuicool.com/");     // 创建httpget实例
        
        // 用逗号分隔显示可以同时接受多种编码
        httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
        httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
        // 查看默认request头部信息
        System.out.println("Accept-Charset:" + httpGet.getFirstHeader("Accept-Charset"));
        
        
        /** RequestConfig类 专门用于配置参数比如连接时间，读取时间以及前面讲解的代理IP等。**/
        RequestConfig config = RequestConfig.custom()
				                            .setConnectTimeout(5000)  //连接时间，默认是1分钟
				                            .setSocketTimeout(5000)   //读取时间
				                            .build();
        		
        /** 代理IP 
        HttpHost proxy = new HttpHost("116.226.217.54", 9999);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(requestConfig);
        **/
        
        
        // 设置请求头消息User-Agent
        httpGet.setHeader
        (       
            "User-Agent", 
            "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"
        ); 
        
        // 执行http get请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        
        /**
         * 取响应状态Status
         * 
         * 正常情况 执行成功 返回200状态码
         * 请求地址不存在 返回404
         * 服务器内部报错 返回500
         * 有些服务器有防采集，假如你频繁的采集数据，则返回403 拒绝你请求
         * 301、302 重定向错误
         * **/
        System.out.println("Status:"+response.getStatusLine().getStatusCode());
        
        
        // 获取返回实体
        HttpEntity entity = response.getEntity();
        
        /** 
         * 获取到响应类型 Content-Type 
         * 
         * 网页：Content-Type:text/html; charset=utf-8
         * 请求js文件： Content-Type:application/javascript
         * 请求的是文件：Content-Type:application/java-archive
         * 
         * **/
        System.out.println("Content-Type:"+entity.getContentType().getValue());
        
        
        
        // 获取网页内容
        System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); 
        // response关闭
        response.close(); 
        // httpClient关闭
        httpClient.close(); 
	}
	
	
	
	public static void main(String[] args)
	{
		try 
		{
			HttpClinetDemo.executeGet();
		} 
		catch (ClientProtocolException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
















