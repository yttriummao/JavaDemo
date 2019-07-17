/**
 * 
 */
package boc.mao.maven.demo_java.HttpClient;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

/**
 * @author: 猪本聪
 * @description:  
 * @date: 2018年12月18日
 */
public class test 
{
	public static void main(String[] args)
	{
		HttpClient httpClient = new DefaultHttpClient();
		
		// 设置超时时间
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
        
        HttpPost post = new HttpPost("http://dzswj-test.gz-l-tax.gov.cn/thirdparty-web/webservices/sfjrService?wsdl");
        // 构造消息头
        post.setHeader("Content-type", "application/xml; charset=utf-8");
        post.setHeader("Connection", "Close");
        
        // 构建消息实体
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:cn=\"http://cn.gov.chinatax.gt3nf.service/\"><soapenv:Header><wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsse:UsernameToken wsu:Id=\"UsernameToken-D3378B7FD81742432114955205452374\"><wsse:Username>zgyh104</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">vcZ/X2BSDM7WjDteHG7QO9PjlUf4BDG4sPklWOt+vNw=</wsse:Password></wsse:UsernameToken></wsse:Security></soapenv:Header><soapenv:Body><cn:doService><bizXml><![CDATA[<tiripPackage xmlns=\"http://www.chinatax.gov.cn/dataspec/\"><sessionId/><service><serviceId>SWZJ.HXZGCX.DQDJK.ZRRXX</serviceId><clientNo>99999999999</clientNo><tranSeq>zgyh31399999999000002018121712345678</tranSeq><repeatFlag>0</repeatFlag><tranReqDate>2018-12-17</tranReqDate></service><identity><application><applicationId>21A3AB7D88C94D9C9FA002FD4CCE80D6</applicationId><supplier>yhpt</supplier><version>1</version><authenticateType>2</authenticateType><password></password><cert></cert></application></identity><routerSession></routerSession><signData><signType>0</signType><signSource>000</signSource><signValue>000</signValue></signData><businessContent><subPackage><id>1</id><content>{\"SFZJHM\":\"522524197105100192\"}</content></subPackage></businessContent></tiripPackage>]]></bizXml></cn:doService></soapenv:Body></soapenv:Envelope>";
        StringEntity entity = new StringEntity(xml, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/xml");
        post.setEntity(entity);
        
        try 
        {
			HttpResponse response = httpClient.execute(post);
			
			// 检验返回码
	        int statusCode = response.getStatusLine().getStatusCode();
	        System.out.println(statusCode);
	        System.out.println(response.getEntity());
	        System.out.println("Content-Type:"+entity.getContentType().getValue());
	        
	        String strResult = EntityUtils.toString(response.getEntity());
	        System.out.println("响应内容：" + strResult); 
	        if(statusCode != HttpStatus.SC_OK)
	        {
	            System.out.println("请求出错");
	        }
	        else
	        {
	            int retCode = 0;
	            String sessendId = "";
	            // 返回码中包含retCode及会话Id
	            for(Header header : response.getAllHeaders())
	            {
	                if(header.getName().equals("retcode"))
	                {
	                    retCode = Integer.parseInt(header.getValue());
	                }
	                if(header.getName().equals("SessionId"))
	                {
	                    sessendId = header.getValue();
	                }
	            }
	        }
		} 
        catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




















