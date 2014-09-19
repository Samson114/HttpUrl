package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Stand1 {
	
	public void Test(String cookiee){
	
		
		try {
			URL url = null;
		
		
		

//	url = new URL("http://jw.djtu.edu.cn/academic/index.jsp");
	
	
		url = new URL("http://jw.djtu.edu.cn/academic/manager/coursearrange/showTimetable.do?id=189708&yearid=33&termid=2&timetableType=STUDENT&sectionType=BASE");
	
//	url = new URL("http://jw.djtu.edu.cn/academic/manager/examstu/studentQueryAllExam.do");

	String strPost = "groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591";
	HttpURLConnection httpurlconnection = null;
	httpurlconnection = (HttpURLConnection) url.openConnection();
	httpurlconnection.setFollowRedirects(true);
	httpurlconnection.setInstanceFollowRedirects(true);
	httpurlconnection.setDoOutput(true); // 需要向服务器写数据
	httpurlconnection.setDoInput(true); //
	httpurlconnection.setUseCaches(false); // 获得服务器最新的信息
	httpurlconnection.setAllowUserInteraction(false);
	httpurlconnection.setRequestMethod("GET");
	httpurlconnection.addRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//	httpurlconnection.setRequestProperty("Referer","http://jw.djtu.edu.cn/academic/student/exam/index.jsdo?stuid=189708"); 
	httpurlconnection.setRequestProperty("Referer","http://jw.djtu.edu.cn/academic/student/currcourse/currcourse.jsdo?groupId=&moduleId=2000"); 
	httpurlconnection.setRequestProperty("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
	httpurlconnection.setRequestProperty("Accept-Encoding","gzip, deflate");
	httpurlconnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
	httpurlconnection.setRequestProperty("Host", "jw.djtu.edu.cn");
	httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
//	httpurlconnection.setRequestProperty("Cache-Control", "no-cache");
//	httpurlconnection.setRequestProperty("Cookie","JSESSIONID=DF45D4526CBF0C693252D794FDBBEF1C");
	httpurlconnection.setRequestProperty("Cookie",cookiee);
	httpurlconnection.getOutputStream().write(strPost.getBytes());
	httpurlconnection.getOutputStream().flush();
	httpurlconnection.getOutputStream().close();
	httpurlconnection.connect();
	int code = httpurlconnection.getResponseCode();
	System.out.println("code　 " + code);

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
	
	
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}

