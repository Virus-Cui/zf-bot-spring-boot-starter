package cn.mrcsh.qhbotspringbootstarter.ws.handler.handlers;

import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.ws.handler.AbstractMessageHandler;
import cn.mrcsh.qhbotspringbootstarter.module.WebSocketMessageModule;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.Identify;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 12:57
 * @Author: Virus_Cui
 */
@Slf4j
public class HelloHandler extends AbstractMessageHandler {

    /**

     * @param s
     * @param webSocketClient
     */
    @Override
    public void hand(String s,WebSocketClient webSocketClient) {
        log.info("开始鉴权");
        WebSocketMessageModule<Identify> module = new WebSocketMessageModule<>();
        Identify identify = new Identify();
        identify.setToken(Const.accessToken);
        identify.setIntents(Const.intents);
        module.setOp(2);
        module.setD(identify);
        System.out.println(XJson.toJsonString(module));
        webSocketClient.send(XJson.toJsonString(module));
        log.info("发送鉴权指令成功");
    }
}
