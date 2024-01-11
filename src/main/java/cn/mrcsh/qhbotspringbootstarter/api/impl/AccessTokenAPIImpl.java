package cn.mrcsh.qhbotspringbootstarter.api.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.mrcsh.qhbotspringbootstarter.api.AccessTokenAPI;
import cn.mrcsh.qhbotspringbootstarter.config.QQBotProperty;
import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.AccessParam;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2023/11/7 13:34
 * @Author: Virus_Cui
 */
@Service
public class AccessTokenAPIImpl implements AccessTokenAPI {

    @Autowired
    private QQBotProperty property;

    @Override
    public String getAccessToken(String appId, String clintSecret) {
        AccessParam param = new AccessParam();
        param.setAppId(property.getBotAppId());
        param.setClientSecret(property.getBotSecretKey());
        HttpRequest body = HttpUtil.createRequest(Method.POST, "https://bots.qq.com/app/getAppAccessToken").body(XJson.toJsonString(param));
        return XJson.of(body.execute().body()).get("access_token").asText();
    }
}
