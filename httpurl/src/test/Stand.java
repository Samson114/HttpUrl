package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Stand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			url = new URL("http://jw.djtu.edu.cn/academic/j_acegi_security_check");
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
						.getOutputStream(), "GBK");
				
				
		        //其中的memberName和password也是阅读html代码得知的，即为表单中对应的参数名称
				out.write("groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591"); // post的关键所在！
				out.flush();
				out.close();
		
				// 取得cookie，相当于记录了身份，供下次访问时使用
				String cookieVal = httpurlconnection0.getHeaderField("Set-Cookie");
				String[] cookie_full=cookieVal.split(";");
				String cookie0=cookie_full[0];
				String cookie1=cookie_full[1];
				System.out.println("执行到cookieVal="+cookieVal);
				System.out.println("执行到result_cookie="+cookie0);
//				cookie0="JSESSIONID=DF45D4526CBF0C693252D794FDBBEF1C";
//				
//				cookie0="JSESSIONID=8519454FD55B7E3A1D975551674315E0";
		Stand1 stand =new Stand1();
		
		stand.Test(cookie0);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		/*finally {
		if (httpurlconnection != null)
		httpurlconnection.disconnect();
		}*/
	}
		
}
