package test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("执行到start");
        // 连接地址（通过阅读html源代码获得，即为登陆表单提交的URL）
//		String surl = "http://login.goodjobs.cn/index.php/action/UserLogin";
		String surl = "http://jw.djtu.edu.cn/academic/j_acegi_security_check";
		/**
		 * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using
		 * java.net.URL and //java.net.URLConnection
		 */
		try {
			
		URL url = new URL(surl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		/**
		 * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
		 * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
		 */
		connection.setDoOutput(true);
		connection.setRequestMethod("POST"); 
//		connection.setUseCaches(false); 
//		connection.setRequestProperty("Content-type", "application/x-java-serialized-object"); 
		connection.setRequestProperty("accept", "text/html");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; rv:2.0b11) Gecko/20100101 Firefox/4.0b11");
//---------------
	/*	// 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法， 
		// 所以在开发中不调用上述的connect()也可以)。 
		OutputStream outStrm = connection.getOutputStream(); 

		// 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象。 
		ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm); 

		// 向对象输出流写出数据，这些数据将存到内存缓冲区中 
		objOutputStrm.writeObject(new String("groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591")); 

		// 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream） 
		objOutputStrm.flush(); 

		// 关闭流对象。此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中, 
		// 在调用下边的getInputStream()函数时才把准备好的http请求正式发送到服务器 
		objOutputStrm.close(); */
//---------------
		/**
		 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
		 */
		OutputStreamWriter out;
		
			out = new OutputStreamWriter(connection
					.getOutputStream(), "GBK");
			
			
	        //其中的memberName和password也是阅读html代码得知的，即为表单中对应的参数名称
//			out.write("memberName=myMemberName&password=myPassword"); // post的关键所在！
//			out.write("backUrl=&memberName=myMemberName&password=myPassword&x=54&y=11");
			out.write("groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591"); // post的关键所在！
//			out.write("j_username=1018120627&j_password=dljt591"); // post的关键所在！
			// remember to clean up
			out.flush();
			out.close();
			
			// 取得cookie，相当于记录了身份，供下次访问时使用
			String cookieVal = connection.getHeaderField("Set-Cookie");
			
			
			
			String[] cookie_full=cookieVal.split(";");
			String cookie0=cookie_full[0];
			String cookie1=cookie_full[1];
			System.out.println("执行到cookieVal=“"+cookieVal+"”");
			System.out.println("执行到cookie0=“"+cookie0+"”");
			
			String contentType = connection.getHeaderField("Content-Type");
			System.out.println("执行到contentType=“"+contentType+"”");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		
	}

}
