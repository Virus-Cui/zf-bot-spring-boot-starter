package cn.mrcsh.qhbotspringbootstarter.ws;


import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.ws.handler.WSMessageHandler;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.PlainMessage;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @Date: 2023/9/28 9:24
 * @Author: Virus_Cui
 */

@Slf4j
public class TXWebSocketClient extends WebSocketClient {


    public TXWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log.info("连接成功");
    }

    @Override
    public void onMessage(String s) {
        if(Const.heartLog){
            log.info(s);
        }
        WSMessageHandler.hand(s, this);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        log.info("关闭连接");
    }

    @Override
    public void onError(Exception e) {
        log.error("错误", e);
    }
}
