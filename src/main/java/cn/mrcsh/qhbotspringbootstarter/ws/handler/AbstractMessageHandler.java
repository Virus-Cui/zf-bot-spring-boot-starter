package cn.mrcsh.qhbotspringbootstarter.ws.handler;

import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 12:47
 * @Author: Virus_Cui
 */
public abstract class AbstractMessageHandler {
    public abstract void hand(String s,WebSocketClient webSocketClient);
}
