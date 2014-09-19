package test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Taobao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	        String surl = "http://jw.djtu.edu.cn/academic/j_acegi_security_check";
	        // String surl = "http://localhost:8080/jkl.html";
	        URL url = null;
	        try {
	            url = new URL(surl);
	            HttpURLConnection connection = null;
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setDoOutput(true);
	            connection.setRequestMethod("POST");
	            OutputStreamWriter out = null;
	            out = new OutputStreamWriter(connection.getOutputStream(), "GBK");
	            
	            String params ="groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=dljt591";
	            out.write(params);
	            out.flush();
	            out.close();
	            String  cookies = connection.getHeaderField("Set-Cookie");
	    	    System.out.println("cookie="+cookies);
	    	    
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	     
	      
	        
	     
	       
	      
		
	}

}
