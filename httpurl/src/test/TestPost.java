package test;

import java.io.BufferedReader;   
import java.io.IOException;   
import java.io.InputStream;   
import java.io.InputStreamReader;   
import java.io.OutputStreamWriter;   
import java.net.URL;   
import java.net.URLConnection;   
  
public class TestPost {   
  
    public static void testPost() throws IOException {   
  
    	//连接地址
//    	String surl = "http://219.238.180.***:80/.../loginservlet?command=login";
//    	String surl = "http://115.28.163.120/aichi2/j_spring_security_check";  //成功
    	String surl = "http://www.weduty.com/login.action";
    	
        /**  
         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using  
         *  java.net.URL and //java.net.URLConnection  
         */  
        URL url = new URL(surl); 
        URLConnection connection = url.openConnection(); 
        
        /**  
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。  
         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：  
         */  
        connection.setDoOutput(true);   
        /**  
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...  
         */  
        OutputStreamWriter out = new OutputStreamWriter(connection   
                .getOutputStream(), "GBK");   
        out.write("r=%2Fweixinbusi.action%3Fview_free%3D0&loginID=%E5%BE%AE%E8%87%A3%E5%9C%A8%E5%BE%AE%E5%95%86%E5%9F%8E&passwd=duyuxuan721819&codenum=+%E9%AA%8C%E8%AF%81%E7%A0%81&remember="); //post的关键所在！
       /* String username="huanglin";
        String password="huanglin";
        out.write("j_username="+username+"&j_password="+password); //post的关键所在！
*/        // remember to clean up   
        out.flush();   
        out.close();   
        /**  
         * 这样就可以发送一个看起来象这样的POST：   
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:  
         * text/plain Content-type: application/x-www-form-urlencoded  
         * Content-length: 99 username=bob password=someword  
         */  
        // 一旦发送成功，用以下方法就可以得到服务器的回应：   
        String sCurrentLine;   
        String sTotalString;   
        sCurrentLine = "";   
        sTotalString = "";   
        InputStream l_urlStream;   
        l_urlStream = connection.getInputStream();   
        // 传说中的三层包装阿！   
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(   
                l_urlStream));   
        while ((sCurrentLine = l_reader.readLine()) != null) {   
            sTotalString += sCurrentLine + "\r\n";   
  
        }   
        System.out.println(sTotalString);   
    }   
  
    public static void main(String[] args) throws IOException {   
  
        testPost();   
  
    }   
  
}  

