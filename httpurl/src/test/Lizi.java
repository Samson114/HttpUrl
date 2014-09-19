package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Lizi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String surl = "http://jw.djtu.edu.cn/academic/j_acegi_security_check";
		
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
//				out.write("memberName=myMemberName&password=myPassword"); // post的关键所在！
				out.write("groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591"); // post的关键所在！
				// remember to clean up
				out.flush();
				out.close();
				
				/*url = new URL("http://jw.djtu.edu.cn/academic/guest/calendar/showCurrentWeekInSchoolCalendar.jsp");
					HttpURLConnection httpurlconnection = null;
					httpurlconnection = (HttpURLConnection) url.openConnection();
					httpurlconnection = (HttpURLConnection) url.openConnection();
//					httpurlconnection0.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
//					httpurlconnection0.setRequestProperty("Host","jw.djtu.edu.cn");
					httpurlconnection.setRequestProperty("Referer","http://jw.djtu.edu.cn/jwzx/index.do"); 
					httpurlconnection.connect();
				String cookie0 = httpurlconnection.getHeaderField("Set-Cookie");
				System.out.println("执行到result_cookie="+cookie0);*/
			
				//-----------------------	
//				URLConnection connection1 = new URL(url).openConnection();
				List<String> cookies = httpurlconnection0.getHeaderFields().
		                get("Set-Cookie");
				//Then use the same cookies on all subsequent requests.
				System.out.println("执行到cookies="+cookies);
		//-----------------------
			
			/*	// 取得cookie，相当于记录了身份，供下次访问时使用
				String cookieVal = httpurlconnection0.getHeaderField("Set-Cookie");
				String[] cookie_full=cookieVal.split(";");
				String cookie0=cookie_full[0];
				String cookie1=cookie_full[1];
				System.out.println("执行到cookieVal="+cookieVal);
				System.out.println("执行到cookie0="+cookie0);
				
				 cookie0="JSESSIONID=55DD81003B5F388C760632D71B5E73FE";*/
			
		HttpURLConnection httpurlconnection = null;	
//		url = new URL("http://jw.djtu.edu.cn/academic/index.jsp");
		url = new URL("http://jw.djtu.edu.cn/academic/manager/coursearrange/showTimetable.do?id=189708&yearid=33&termid=2&timetableType=STUDENT&sectionType=BASE");
	
		String strPost = "groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591";
		httpurlconnection = (HttpURLConnection) url.openConnection();
//		httpurlconnection.setFollowRedirects(true);
//		httpurlconnection.setInstanceFollowRedirects(true);
		httpurlconnection.setDoOutput(true); // 需要向服务器写数据
//		httpurlconnection.setDoInput(true); //
//		httpurlconnection.setUseCaches(false); // 获得服务器最新的信息
//		httpurlconnection.setAllowUserInteraction(false);
//		httpurlconnection.setRequestMethod("POST");
		
//		httpurlconnection.addRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		
		/*httpurlconnection.setRequestProperty("Referer","http://jw.djtu.edu.cn/academic/index.jsp"); 
		httpurlconnection.setRequestProperty("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		httpurlconnection.setRequestProperty("Accept-Encoding","gzip, deflate");
		httpurlconnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
		httpurlconnection.setRequestProperty("Host", "jw.djtu.edu.cn");
//		httpurlconnection.setRequestProperty("Content-Length", strPost.length()+ "");
		httpurlconnection.setRequestProperty("Content-Length","62");
		httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
//		httpurlconnection.setRequestProperty("Cache-Control", "no-cache");
		httpurlconnection.setRequestProperty("Cookie", cookie0);
		httpurlconnection.getOutputStream().write(strPost.getBytes());
		httpurlconnection.getOutputStream().flush();
		httpurlconnection.getOutputStream().close();
		httpurlconnection.connect();*/
//		httpurlconnection.setRequestProperty("Referer","http://jw.djtu.edu.cn/academic/index.jsp"); 
		
		
		
		/*httpurlconnection.setRequestProperty("Referer","http://jw.djtu.edu.cn/academic/student/currcourse/currcourse.jsdo?groupId=&moduleId=2000"); 
		httpurlconnection.setRequestProperty("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		httpurlconnection.setRequestProperty("Accept-Encoding","gzip, deflate");
		httpurlconnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
		httpurlconnection.setRequestProperty("Host", "jw.djtu.edu.cn");
		httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
		httpurlconnection.setRequestProperty("Cache-Control", "max-age=0");*/
//		httpurlconnection.setRequestProperty("Cookie","JSESSIONID=BC16281FB7D559EB90B0ACE34881B526");
		

		
//		httpurlconnection.setRequestProperty("Cookie",cookie0);
		httpurlconnection.getOutputStream().write(strPost.getBytes());
		httpurlconnection.getOutputStream().flush();
		httpurlconnection.getOutputStream().close();
		httpurlconnection.connect();
		int code = httpurlconnection.getResponseCode();
		System.out.println("code　 " + code);
//		String result_cookie = httpurlconnection.getHeaderField("Set-Cookie");
//		System.out.print(cookie0 + "; " + result_cookie);
		/*httpurlconnection.disconnect();
		url = new URL("http://www.examda.com/");
		httpurlconnection = (HttpURLConnection) url.openConnection();
		httpurlconnection.setRequestProperty("User-Agent", "Internet Explorer");
		httpurlconnection.setRequestProperty("Host","www.examda.com");
		httpurlconnection.setRequestProperty("Cookie", cookie0 + "; " + cookie1);
		httpurlconnection.connect();*/
		InputStream urlStream = httpurlconnection.getInputStream();
		BufferedInputStream buff = new BufferedInputStream(urlStream);
		Reader r = new InputStreamReader(buff, "GBK");
		BufferedReader br = new BufferedReader(r);
		StringBuffer strHtml = new StringBuffer("");
		String strLine = null;
		while ((strLine = br.readLine()) != null)
		{
		strHtml.append(strLine + "\n");
		}
		System.out.print(strHtml.toString());
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
