package test;

import javax.annotation.Resource;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class FuckWeixin {
    
    private Logger log = LoggerFactory.getLogger(FuckWeixin.class);
    private String loginUrl = "https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN";
    private String sendUrl = "https://mp.weixin.qq.com/cgi-bin/singlesend?t=ajax-response&lang=zh_CN";
    private String account = "1002895777@qq.com";//公众平台用户
    private String password = "zaq12wsx7895123"; //公众平台密码
    private boolean isLogin = false;
    private String cookiestr;
    private String token = null;
    
    @Resource
    private HttpClient httpClient;
    public String getLoginUrl() {
        return loginUrl;
    }
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
    public String getSendUrl() {
        return sendUrl;
    }
    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login() {
        PostMethod post = new PostMethod(loginUrl);
        post.addParameter(new NameValuePair("username", account));
        post.addParameter(new NameValuePair("pwd", DigestUtils.md5Hex(password)));
        post.addParameter(new NameValuePair("imgcode", ""));
        post.addParameter(new NameValuePair("f", "json"));
        //针对最新的改版
        post.setRequestHeader("Host", "mp.weixin.qq.com");
        post.setRequestHeader("Referer", "https://mp.weixin.qq.com/");
        //结束
        try {
            int code = httpClient.executeMethod(post);
            if (HttpStatus.SC_OK == code) {
                String res = post.getResponseBodyAsString();
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(res);
                // Long verifyCode = (Long) obj.get("ShowVerifyCode");
                String msg = (String) obj.get("ErrMsg");
                Long errCode = (Long) obj.get("ErrCode");
                // Long ret = (Long) obj.get("Ret");
                if (0 == errCode) {
                    isLogin = true;
                    token = StringUtils.substringAfter(msg, "token=");
                    if (null == token){
                        token = StringUtils.substringBetween(msg, "token=", "&");
                    }
                    
                    StringBuffer cookie = new StringBuffer();
                    for (Cookie c : httpClient.getState().getCookies()) {
                        cookie.append(c.getName()).append("=").append(c.getValue()).append(";");
                    }
                    this.cookiestr = cookie.toString();
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    
    public boolean sendMessage(String fakeid, String content) {
        if (isLogin) {
            PostMethod post = new PostMethod(sendUrl);
            post.setRequestHeader("Cookie", this.cookiestr);
            post.setRequestHeader("Host", "mp.weixin.qq.com");
            post.setRequestHeader("Referer", "https://mp.weixin.qq.com/cgi-bin/singlemsgpage?token=" + token + "&fromfakeid=" + fakeid
                    + "&msgid=&source=&count=20&t=wxm-singlechat&lang=zh_CN");
            post.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
            post.addParameter(new NameValuePair("type", "1"));
            post.addParameter(new NameValuePair("content", content));
            post.addParameter(new NameValuePair("error", "false"));
            post.addParameter(new NameValuePair("imgcode", ""));
            post.addParameter(new NameValuePair("tofakeid", fakeid));
            post.addParameter(new NameValuePair("token", token));
            post.addParameter(new NameValuePair("ajax", "1"));
            try {
                int code = httpClient.executeMethod(post);
                if (HttpStatus.SC_OK == code) {
                    System.out.println(post.getResponseBodyAsString());
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        } else {
            login();
            sendMessage(fakeid, content);
        }
        return false;
    }
    
    public String getFakeid(String openid) {
        if (isLogin) {
            PostMethod post = new PostMethod("https://mp.weixin.qq.com/cgi-bin/contactmanagepage?t=wxm-friend&token=" + token
                    + "&lang=zh_CN&pagesize=10&pageidx=0&type=0&groupid=0");
            post.setRequestHeader("Cookie", this.cookiestr);
            post.setRequestHeader("Host", "mp.weixin.qq.com");
            post.setRequestHeader("Referer", "https://mp.weixin.qq.com/cgi-bin/contactmanagepage?t=wxm-friend&token=" + token
                    + "&lang=zh_CN&pagesize=10&pageidx=0&type=0");
            post.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
            post.addParameter(new NameValuePair("token", token));
            post.addParameter(new NameValuePair("ajax", "1"));
            try {
                int code = httpClient.executeMethod(post);
                if (HttpStatus.SC_OK == code) {
                    String str = post.getResponseBodyAsString();
                    String userjson = StringUtils.substringBetween(str, "<script id=\"json-friendList\" type=\"json/text\">", "</script>");
                    System.out.println(userjson);
                    JSONParser parser = new JSONParser();
                    try {
                        JSONArray array = (JSONArray) parser.parse(userjson);
                        for (int i = 0; i < array.size(); i++) {
                            JSONObject obj = (JSONObject) array.get(i);
                            String fakeid = (String) obj.get("fakeId");
                            // String name = (String) obj.get("nickName");
                            // String groupId = (String) obj.get("groupId");
                            if (compareFakeid(fakeid, openid)) {
                                return fakeid;
                            }
                        }
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        } else {
            login();
            return getFakeid(openid);
        }
        return null;
    }
    
    private boolean compareFakeid(String fakeid, String openid) {
        PostMethod post = new PostMethod("https://mp.weixin.qq.com/cgi-bin/singlemsgpage?token=" + token + "&fromfakeid=" + fakeid
                + "&msgid=&source=&count=5&t=wxm-singlechat&lang=zh_CN");
        post.setRequestHeader("Cookie", this.cookiestr);
        post.setRequestHeader("Host", "mp.weixin.qq.com");
        post.setRequestHeader("Referer", "https://mp.weixin.qq.com/cgi-bin/contactmanagepage?t=wxm-friend&token=" + token
                + "&lang=zh_CN&pagesize=10&pageidx=0&type=0");
        post.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
        post.addParameter(new NameValuePair("token", token));
        post.addParameter(new NameValuePair("ajax", "1"));
        try {
            int code = httpClient.executeMethod(post);
            if (HttpStatus.SC_OK == code) {
                String str = post.getResponseBodyAsString();
                String msgJson = StringUtils.substringBetween(str, "<script id=\"json-msgList\" type=\"json\">", "</script>");
                JSONParser parser = new JSONParser();
                try {
                    JSONArray array = (JSONArray) parser.parse(msgJson);
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject obj = (JSONObject) array.get(i);
                        String content = (String) obj.get("content");
                        if (content.contains(openid)) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        FuckWeixin util = new FuckWeixin();
        util.login();
        util.sendMessage(util.getFakeid("openid"), "测试微信消息");
    }
}