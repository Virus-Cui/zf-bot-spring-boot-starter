package cn.mrcsh.qhbotspringbootstarter.utils;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.config.Const;

import java.io.File;

/**
 * @Date: 2023/9/28 9:46
 * @Author: Virus_Cui
 */
public class XHttp {

    public static String get(String url) {
        HttpResponse execute = HttpUtil.createRequest(Method.GET,url.contains("https://")?url:Const.OPENAPI+url).header("Authorization", Const.token).header("X-Union-Appid",Cache.property.getBotAppId()).execute();
        String body = execute.body();
        execute.close();
        return body;
    }

    public static String post(String url, String body) {
        HttpResponse execute = HttpUtil.createRequest(Method.POST, url.contains("https://")?url:Const.OPENAPI +url).body(body).header("Authorization", Const.token).header("X-Union-Appid",Cache.property.getBotAppId()).execute();
        String res = execute.body();
        execute.close();
        return res;
    }

    public static String postWithForm(String url, String body,String name, File file) {
        HttpResponse execute = HttpUtil.createRequest(Method.POST, url.contains("https://")?url:Const.OPENAPI +url).body(body).header("Authorization", Const.token).header("X-Union-Appid",Cache.property.getBotAppId()).form(name, file).contentType("multipart/form-data").execute();
        String res = execute.body();
        execute.close();
        return res;
    }
}
