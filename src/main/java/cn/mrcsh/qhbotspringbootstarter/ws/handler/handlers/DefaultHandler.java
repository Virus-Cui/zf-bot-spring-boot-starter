package cn.mrcsh.qhbotspringbootstarter.ws.handler.handlers;

import cn.mrcsh.qhbotspringbootstarter.ws.handler.AbstractMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 12:55
 * @Author: Virus_Cui
 */
@Slf4j
public class DefaultHandler extends AbstractMessageHandler {
    @Override
    public void hand(String s,WebSocketClient webSocketClient) {
      log.info("未知消息类型,Data:{}",s);
    }
}
