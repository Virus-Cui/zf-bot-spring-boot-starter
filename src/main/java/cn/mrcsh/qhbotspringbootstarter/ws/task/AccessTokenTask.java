package cn.mrcsh.qhbotspringbootstarter.ws.task;

import cn.mrcsh.qhbotspringbootstarter.api.AccessTokenAPI;
import cn.mrcsh.qhbotspringbootstarter.api.impl.AccessTokenAPIImpl;
import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.config.QQBotProperty;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date: 2023/11/7 13:39
 * @Author: Virus_Cui
 */
@Component
public class AccessTokenTask implements Runnable {
    @Autowired
    private AccessTokenAPI accessTokenAPI;

    @Autowired
    private QQBotProperty property;

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            Const.accessToken = "QQBot "+accessTokenAPI.getAccessToken(property.getBotAppId(), property.getBotSecretKey());
            Thread.sleep(1000);
        }
    }
}
