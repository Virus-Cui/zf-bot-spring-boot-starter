package cn.mrcsh.qhbotspringbootstarter.utils;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.mrcsh.qhbotspringbootstarter.config.Const;
import org.springframework.stereotype.Component;

/**
 * @Date: 2023/9/28 9:46
 * @Author: Virus_Cui
 */
public class XHttp {

    public static String get(String url) {
        HttpResponse execute = HttpUtil.createRequest(Method.GET,Const.baseURL+url).header("Authorization", Const.token).execute();
        String body = execute.body();
        execute.close();
        return body;
    }

    public static String post(String url, String body) {
        HttpResponse execute = HttpUtil.createRequest(Method.POST, Const.baseURL+url).body(body).header("Authorization", Const.token).execute();
        String res = execute.body();
        execute.close();
        return res;
    }
}
