package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Baidu {

//	已经测试成功，能够成功登陆365的后台  但是教务在线 没有成功	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String surl = "http://jw.djtu.edu.cn/academic/j_acegi_security_check";
		System.out.println("start");
		URL url = null;
		try {
			url = new URL("http://10.1.1.110/eportal/webgateuser.do?" +
					"method=login_ajax_pure_internet&fav=b242e338afc7a5526e8e5f2fdb784c26_25e8787f9aa782790ec4e439241eb56f_ace_zxt-wuxy");
//			url = new URL("http://jw.djtu.edu.cn/academic/j_acegi_security_check");
//			url = new URL("http://www.weduty.com/login.action");
//			url = new URL("https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN");
//			url = new URL("http://115.28.163.120/aichia/j_spring_security_check");
			
//			url = new URL("http://www.365weifu.com/remeber.action");	
//			url = new URL("http://passport.58.com/dounionlogin");
			
			
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
				
				out.write("s=b242e338afc7a5526e8e5f2fdb784c26&redirectUrl=&" +
						"redirectFlag=&portalAuthType=&serviceip=&monitorPort=&" +
						"sendPort=&forceUrl=&sessionId=&t=ace&ssid=52c10b0934da8da9&" +
						"apmac=&mac=3805C35CC7AC6922724859428FD84C89&port=&" +
						"url=fc8cddebb8d9d2bde37cdfe1f2ef5e4cf58151a1ece80b68ea6306b89f0ea3ce&" +
						"vid=&net_access_type=&srcip=&userip=&ip=25e8787f9aa782790ec4e439241eb56f&" +
						"userIp=25e8787f9aa782790ec4e439241eb56f&dst_url=ec916866724f776f6d7e5cdf5f1baf56bf648d523ebf7678&" +
						"vrfg=&securityDomainControlType=&" +
						"index_params=s%3Db242e338afc7a5526e8e5f2fdb784c26%26ip%3D25e8787f9aa782790ec4e439241eb56f%26url%3Dfc8cddebb8d9d2bde37cdfe1f2ef5e4cf58151a1ece80b68ea6306b89f0ea3ce%26t%3Dace&" +
						"authType=web&" +
						"username=zxt-zhouyp&" +
						"usernameHidden=zxt-zhouyp&" +
						"pwd=zxt-zhouyp&" +
						"validcode=no_check");
				
				
				
//				out.write("j_username=bh&j_password=1&sysName=");
//				out.write("username=339188534%40qq.com&pwd=5795f65bbf3e745939c182ff330645bb&imgcode=&f=json");
//				out.write("loginID=weichenzaiwgj&passwd=521!!vbelongo&autoLogin=0&remembername=0&codenum=+%E9%AA%8C%E8%AF%81%E7%A0%81");
//				out.write("r=%2Fweixinbusi.action%3Fview_free%3D0&loginID=%E5%BE%AE%E8%87%A3%E5%9C%A8%E5%BE%AE%E5%95%86%E5%9F%8E&passwd=duyuxuan721819&codenum=+%E9%AA%8C%E8%AF%81%E7%A0%81&remember="); // post的关键所在！
//				out.write("isweak=0&path=http%3A%2F%2Fmy.58.com%3Fpts%3D1392705981287&p1=fc6837be276dc5f851927dfce54307ba&p2=56feb30af8649214a9c906ae3516a18f&p3=6e27214b6c6e2fd5321ab39f8f30aa127d6aa14f0bdba8a6cf56f9a2319b78b4144f518ba8db37144989da48365f6f20fa2d475c555ac032cce9de222c18d301eeea91146ab5d6b65ac2fd3f1c9741afc5960292036411dc1fe02f60efab9ecb19f8f5d70eef612bb1d769b1a42bf8ee815d14aa40a1ad891c59129fd576b17e&timesign=1392706014258&ptk=f9c4ebeb8e0c41d995a627573aec3983&cd=5152&username=13840821952&password=password&mcresult=0773677539193195800794410121");
				out.flush();
				out.close();
				
				// 取得cookie，相当于记录了身份，供下次访问时使用
				String cookieVal = httpurlconnection0.getHeaderField("Set-Cookie");
				String[] cookie_full=cookieVal.split(";");
				String cookie0=cookie_full[0];
				String cookie1=cookie_full[1];
				System.out.println("执行到cookieVal="+cookieVal);
				System.out.println("执行到cookie0="+cookie0);
				
	//这之前是获得cookie的代码	
//				将前面获得的cookie 用在下面的代码中会报错
//				但是用正常途径登陆教务在线  生成的cookie 能够成功获得结果
				
		//这个是通过正常途径登陆教务在线  生成的cookie
//		cookie0="JSESSIONID=5936B23A3952087A26A8F7804294AAD3";
			
		
	//下面是是通cookie 获得页面的代码			 
				 
		HttpURLConnection httpurlconnection = null;	
//		url = new URL("http://jw.djtu.edu.cn/academic/index.jsp");
//		url = new URL("http://jw.djtu.edu.cn/academic/manager/coursearrange/showTimetable.do?id=189708&yearid=33&termid=2&timetableType=STUDENT&sectionType=BASE");
//		String strPost = "groupId=&j_username=1018120627&login=%E7%99%BB%E5%BD%95&j_password=6840880";
		
//		url = new URL("http://www.weduty.com/weixinbusi.action?view_free=0");
//		url = new URL("http://www.weduty.com/custommenu.action");
//		url = new URL("https://mp.weixin.qq.com/cgi-bin/contactmanage?t=user/index&pagesize=10&pageidx=0&type=0&token=634027011&lang=zh_CN");
//		url = new URL("http://my.58.com/myseekjob/1");
		
		url = new URL("http://10.1.1.110/eportal/webgateuser.do?method=login_ajax_pure_internet&fav=b242e338afc7a5526e8e5f2fdb784c26_25e8787f9aa782790ec4e439241eb56f_ace_zxt-wuxy#");
		
//		url = new URL("http://115.28.163.120/aichia/frame/frameList");
//		url = new URL("http://www.365weifu.com/weixinbusi.action?view_free=0");
//		url = new URL("http://www.365weifu.com/materials.action?op=getAll");
//		String strPost = "r=%2Fweixinbusi.action%3Fview_free%3D0&loginID=%E5%BE%AE%E8%87%A3%E5%9C%A8%E5%BE%AE%E5%95%86%E5%9F%8E&passwd=duyuxuan721819&codenum=+%E9%AA%8C%E8%AF%81%E7%A0%81&remember="; 
//		String strPost ="isweak=0&path=http%3A%2F%2Fmy.58.com%3Fpts%3D1392705981287&p1=fc6837be276dc5f851927dfce54307ba&p2=56feb30af8649214a9c906ae3516a18f&p3=6e27214b6c6e2fd5321ab39f8f30aa127d6aa14f0bdba8a6cf56f9a2319b78b4144f518ba8db37144989da48365f6f20fa2d475c555ac032cce9de222c18d301eeea91146ab5d6b65ac2fd3f1c9741afc5960292036411dc1fe02f60efab9ecb19f8f5d70eef612bb1d769b1a42bf8ee815d14aa40a1ad891c59129fd576b17e&timesign=1392706014258&ptk=f9c4ebeb8e0c41d995a627573aec3983&cd=5152&username=13840821952&password=password&mcresult=0773677539193195800794410121";
//		String strPost ="loginID=weichenzaiwgj&passwd=521!!vbelongo&autoLogin=0&remembername=0&codenum=+%E9%AA%8C%E8%AF%81%E7%A0%81";
//		String strPost ="j_username=bh&j_password=1&sysName=";
		String strPost ="s=b242e338afc7a5526e8e5f2fdb784c26&redirectUrl=&" +
				"redirectFlag=&portalAuthType=&serviceip=&monitorPort=&" +
				"sendPort=&forceUrl=&sessionId=&t=ace&ssid=52c10b0934da8da9&" +
				"apmac=&mac=3805C35CC7AC6922724859428FD84C89&port=&" +
				"url=fc8cddebb8d9d2bde37cdfe1f2ef5e4cf58151a1ece80b68ea6306b89f0ea3ce&" +
				"vid=&net_access_type=&srcip=&userip=&ip=25e8787f9aa782790ec4e439241eb56f&" +
				"userIp=25e8787f9aa782790ec4e439241eb56f&dst_url=ec916866724f776f6d7e5cdf5f1baf56bf648d523ebf7678&" +
				"vrfg=&securityDomainControlType=&" +
				"index_params=s%3Db242e338afc7a5526e8e5f2fdb784c26%26ip%3D25e8787f9aa782790ec4e439241eb56f%26url%3Dfc8cddebb8d9d2bde37cdfe1f2ef5e4cf58151a1ece80b68ea6306b89f0ea3ce%26t%3Dace&" +
				"authType=web&" +
				"username=zxt-wuxy&" +
				"usernameHidden=zxt-wuxy&" +
				"pwd=zxt-wuxy&" +
				"validcode=no_check";
		httpurlconnection = (HttpURLConnection) url.openConnection();
		httpurlconnection.setDoOutput(true); // 需要向服务器写数据
		
		
		httpurlconnection.setRequestProperty("Cookie",cookie0);
		httpurlconnection.getOutputStream().write(strPost.getBytes());
		httpurlconnection.getOutputStream().flush();
		httpurlconnection.getOutputStream().close();
		httpurlconnection.connect();
		int code = httpurlconnection.getResponseCode();
		System.out.println("code　 " + code);
		InputStream urlStream = httpurlconnection.getInputStream();
		BufferedInputStream buff = new BufferedInputStream(urlStream);
		Reader r = new InputStreamReader(buff, "utf-8");
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
		
	}

}
