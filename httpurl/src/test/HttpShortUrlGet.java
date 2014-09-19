package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public final class HttpShortUrlGet { 
        private static Log log = LogFactory.getLog(HttpShortUrlGet.class); 

        /** 
         * 执行一个HTTP GET请求，返回请求响应的HTML 
         * 
         * @param url                 请求的URL地址 
         * @param queryString 请求的查询参数,可以为null 
         * @param charset         字符集 
         * @param pretty            是否美化 
         * @return 返回请求响应的HTML 
         */ 
        public static String doGet(String url, String queryString, String charset, boolean pretty) { 
                StringBuffer response = new StringBuffer(); 
                HttpClient client = new HttpClient(); 
                HttpMethod method = new GetMethod(url); 
                try { 
                        if (StringUtils.isNotBlank(queryString)) 
                                //对get请求参数做了http请求默认编码，好像没有任何问题，汉字编码后，就成为%式样的字符串 
                                method.setQueryString(URIUtil.encodeQuery(queryString)); 
                        client.executeMethod(method); 
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator"));
                                        else 
                                                response.append(line); 
                                } 
                                reader.close(); 
                        } 
                        
                } catch (URIException e) { 
                        log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
                } catch (IOException e) { 
                        log.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
                } finally { 
                        method.releaseConnection(); 
                } 
                
                return response.toString(); 
        } 

       /* *//** 
         * 执行一个HTTP POST请求，返回请求响应的HTML 
         * 
         * @param url         请求的URL地址 
         * @param params    请求的查询参数,可以为null 
         * @param charset 字符集 
         * @param pretty    是否美化 
         * @return 返回请求响应的HTML 
         *//* 
        public static String doPost(String url, Map<String, String> params, String charset, boolean pretty) { 
                StringBuffer response = new StringBuffer(); 
                HttpClient client = new HttpClient(); 
                HttpMethod method = new PostMethod(url); 
                //设置Http Post数据 
                if (params != null) { 
                        HttpMethodParams p = new HttpMethodParams(); 
                        for (Map.Entry<String, String> entry : params.entrySet()) { 
                                p.setParameter(entry.getKey(), entry.getValue()); 
                        } 
                        method.setParams(p); 
                } 
                try { 
                        client.executeMethod(method); 
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator"));
                                        else 
                                                response.append(line); 
                                } 
                                reader.close(); 
                        } 
                } catch (IOException e) { 
                        log.error("执行HTTP Post请求" + url + "时，发生异常！", e); 
                } finally { 
                        method.releaseConnection(); 
                } 
                return response.toString(); 
        } 
*/
        public static void main(String[] args) { 
//        	新浪  短域名接口
//        	String str="http://api.t.sina.com.cn/short_url/shorten.json?source=40603046&url_long=http://www.wechenzai.com";
        	
        	
//        	参考百度地图  接口  http://developer.baidu.com/map/webservice-geocoding.htm
        	
//        通过 地址  获得  经纬度	    
//        	String str="http://api.map.baidu.com/geocoder/v2/?address=阜新市太平区&output=json&ak=342c0bced1035142422dc6dce4a863e0&callback=showLocation";
//        		
//        通过ip  获得经纬度
        	String str="http://api.map.baidu.com/location/ip?ak=342c0bced1035142422dc6dce4a863e0&ip=202.198.16.3&coor=bd09ll";
//          通过经纬度  获得  地址 
//          String str="http://api.map.baidu.com/geocoder/v2/?ak=342c0bced1035142422dc6dce4a863e0&callback=renderReverse&location=39.983424,116.322987&output=json&pois=1";
        	String response = doGet(str, null, "GBK", true); 
                
                JSONObject jsonObject = JSONObject.fromObject(response);
                System.out.println("main中 json格式的response---"+jsonObject);
                System.out.println(jsonObject.getJSONObject("content").getJSONObject("point").getString("y"));
                String x=jsonObject.getJSONObject("content").getJSONObject("point").getString("x");
                String y=jsonObject.getJSONObject("content").getJSONObject("point").getString("y");
                
                
//                JSONObject pointObject=JSONObject.fromObject(jsonObject.getString("content"));
//                pointObject.getJSONObject(key)
//                System.out.println(jsonObject.getJSONObject(0).get("columnName")); 
        } 
}