package cn.mrcsh.qhbotspringbootstarter.ws.handler.handlers;

import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.module.WebSocketMessageModule;
import cn.mrcsh.qhbotspringbootstarter.ws.handler.AbstractMessageHandler;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.ReConnect;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 12:59
 * @Author: Virus_Cui
 */
@Slf4j
public class ReconnectHandler extends AbstractMessageHandler {
    @Override
    public void hand(String s, WebSocketClient webSocketClient) {
        log.info("开始自动重连");
        WebSocketMessageModule<ReConnect> webSocketMessageModule = new WebSocketMessageModule<>();
        ReConnect reConnect = new ReConnect();
        reConnect.setSeq(Cache.lastMessageId);
        reConnect.setToken(Const.token);
        reConnect.setSession_id(Cache.botInfo.getSession_id());
        webSocketMessageModule.setOp(6);
        webSocketMessageModule.setD(reConnect);
        webSocketClient.send(JSON.toJSONString(webSocketMessageModule));
        log.info("自动重连发起成功");
    }
}
