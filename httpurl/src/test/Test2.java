package test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		URL url = null;
		
//		url = new URL("http://jw.djtu.edu.cn/academic/j_acegi_security_check");
//		url = new URL("http://www.weduty.com/login.action");
//		url = new URL("https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN");
		try {
			url = new URL("http://1.djtucommunity.sinaapp.com/index.php");
			HttpURLConnection httpurlconnection0 = null;
			httpurlconnection0 = (HttpURLConnection) url.openConnection();
			/**
			 * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
			 * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
			 */
			httpurlconnection0.setDoOutput(true);
			/**
			 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
			 */
			OutputStreamWriter out;
			out = new OutputStreamWriter(httpurlconnection0
						.getOutputStream(), "UTF-8");
				out.write("a=444&pwd=5795f6");
				out.flush();
				out.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}

}
