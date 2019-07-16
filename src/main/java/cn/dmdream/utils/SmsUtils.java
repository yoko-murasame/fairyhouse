package cn.dmdream.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.util.Auth;
import com.qiniu.util.Json;
import com.qiniu.util.StringMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信
 * https://developer.qiniu.com/sms/api/5897/sms-api-send-message
 */
public class SmsUtils {

    private final static String smsHost = "sms.qiniuapi.com";
    private final static String accessKey = "不告诉你";
    private final static String secretKey = "不告诉你";
    private final static String templateId = "";

    /**
     * 直接发送校验短信
     *
     * @param mobile    手机号码必填
     */
    public static Response sendMessageAuto(String mobile) {
        Response response = null;
        try {
            String requestUrl = String.format("%s/v1/message", smsHost);
            StringMap bodyMap = new StringMap();
            bodyMap.put("template_id", templateId);
            bodyMap.put("mobiles", new String[]{mobile});
            bodyMap.put("parameters", new HashMap<String,String>().put("code",genCode()+""));
            response = post(requestUrl, Json.encode(bodyMap).getBytes());

        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 发送短信,官方版本
     *
     * @param templateId 模板Id，必填
     * @param mobiles    手机号码数组，必填
     * @param parameters  参数,必填
     */
    public static Response sendMessage(String templateId, String[] mobiles, Map<String, String> parameters)
            throws QiniuException {
        String requestUrl = String.format("%s/v1/message", smsHost);
        StringMap bodyMap = new StringMap();
        bodyMap.put("template_id", templateId);
        bodyMap.put("mobiles", mobiles);
        bodyMap.put("parameters", parameters);
        return post(requestUrl, Json.encode(bodyMap).getBytes());
    }

    /**
     * 随机生成6位校验码
     * @return
     */
    public static int genCode(){
        int code = (int)((Math.random()*9+1)*100000);
        return code;
    }

    /*
     * 相关请求的方法列表
     * 发送post请求
     * */
    private static Response post(String url, byte[] body) throws QiniuException {
        StringMap headers = composeHeader(url, "POST", body, Client.JsonMime);
        return new Client().post(url, body, headers, Client.JsonMime);
    }

    /**
     * 构造header
     */
    private static StringMap composeHeader(String url, String method, byte[] body, String contentType) {
        StringMap headers = Auth.create(accessKey, secretKey).authorizationV2(url, method, body, contentType);
        headers.put("Content-Type", contentType);
        return headers;
    }

}
