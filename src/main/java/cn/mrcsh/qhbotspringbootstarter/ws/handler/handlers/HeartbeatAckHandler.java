package cn.mrcsh.qhbotspringbootstarter.ws.handler.handlers;

import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.ws.handler.AbstractMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 13:20
 * @Author: Virus_Cui
 */
@Slf4j
public class HeartbeatAckHandler extends AbstractMessageHandler {

    @Override
    public void hand(String s, WebSocketClient webSocketClient) {

    }
}
