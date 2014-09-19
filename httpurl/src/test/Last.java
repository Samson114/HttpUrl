package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Last {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String POSTURL = "http://jw.djtu.edu.cn/academic/j_acegi_security_check";  
		 try { 
			 URL url = new URL(POSTURL);  
		 HttpURLConnection con = (HttpURLConnection) url.openConnection();  
		 con.setDoInput(true);  con.setDoOutput(true);  
		 con.setRequestMethod("POST");  
		 con.setUseCaches(false);  
		 con.setInstanceFollowRedirects(true);    
		 con.connect();    
		 DataOutputStream out = new DataOutputStream(con.getOutputStream());  
		 String str="groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591";  
		 out.writeBytes(str);  
		 out.flush();  
		 out.close();  
		 BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		 String cookieVal = con.getHeaderField("Set-Cookie");
		 System.out.println("执行到result_cookie="+cookieVal);
		 } catch (MalformedURLException e) 
		 {  e.printStackTrace(); } 
		 catch (IOException e)
		 {  e.printStackTrace(); }
		 
		 
		 
		 
	}

}
