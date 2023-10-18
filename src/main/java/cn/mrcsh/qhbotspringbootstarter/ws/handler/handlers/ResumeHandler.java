package cn.mrcsh.qhbotspringbootstarter.ws.handler.handlers;

import cn.mrcsh.qhbotspringbootstarter.ws.handler.AbstractMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 17:14
 * @Author: Virus_Cui
 */
@Slf4j
public class ResumeHandler extends AbstractMessageHandler {
    @Override
    public void hand(String s, WebSocketClient webSocketClient) {
      log.info("客户端重连成功");
    }
}
