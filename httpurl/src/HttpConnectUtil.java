import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class HttpConnectUtil {
	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	private String url;

	public String sendMessage() {
//		url = "http://localhost:8080/demo/jolokia/";
		url = "http://jw.djtu.edu.cn/academic/j_acegi_security_check";
		
		logger.info("=================开始获取信息,地址{}=================");
		String responseMessage = "";
		StringBuffer resposne = new StringBuffer();
		HttpURLConnection httpConnection = null;
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {
			URL urlPost = new URL(url);
			httpConnection = (HttpURLConnection) urlPost.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			// 参数长度太大，不能用get方式
			httpConnection.setRequestMethod("POST");
			// 不使用缓存
			httpConnection.setUseCaches(false);
			// URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
			httpConnection.setInstanceFollowRedirects(true);
			// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
			// 意思是正文是urlencoded编码过的form参数
			httpConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
			// 要注意的是connection.getOutputStream会隐含的进行connect。
			// 实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。
			((org.slf4j.Logger) logger).debug("打开连接:" + url);
			httpConnection.connect();
			out = new DataOutputStream(httpConnection.getOutputStream());
			// The URL-encoded contend
			// 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
			
			List<String> list=new ArrayList<String>();
			list.add("com.sinosoft.one.demo");
			list.add("DEBUG");
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("arguments", list);
			jsonObject.put("mbean", "log4j:logger=Log4j");
			jsonObject.put("type", "exec");
			jsonObject.put("operation", "setProjectLevel");
			//写入参数,DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
			out.writeBytes(jsonObject.toString());
			// flush and close
			out.flush();
			reader = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
			while ((responseMessage = reader.readLine()) != null) {
				resposne.append(responseMessage);
			}

			if (!"failure".equals(resposne.toString())) {
				logger.info("success send to JMX");
			} else {
				((org.slf4j.Logger) logger).debug("failure send to JMX");
			}
			// 将该url的配置信息缓存起来
			return resposne.toString();
		} catch (IOException e) {
			((org.slf4j.Logger) logger).error("连接失败,url={}" , url);
			return "failed";
		} finally {
			try {
				if (null != out) {
					out.close();
				}
				if (null != reader) {
					reader.close();
				}
				if (null != httpConnection) {
					httpConnection.disconnect();
				}
			} catch (Exception e2) {
				((org.slf4j.Logger) logger).error("http connection close error:{}", e2);
			}
		}
	}
	
	public static void main(String avgs[]){
		
		HttpConnectUtil hc=new HttpConnectUtil();
		hc.sendMessage();
	}
}