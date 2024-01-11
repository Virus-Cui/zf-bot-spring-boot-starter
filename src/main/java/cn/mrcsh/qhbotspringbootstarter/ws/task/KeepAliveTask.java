package cn.mrcsh.qhbotspringbootstarter.ws.task;

import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.module.WebSocketMessageModule;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import cn.mrcsh.qhbotspringbootstarter.ws.TXWebSocketClient;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date: 2023/9/28 10:47
 * @Author: Virus_Cui
 * 发送心跳包
 */
public class KeepAliveTask {

    private Thread task;

    public void start(WebSocketClient client){
        task = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(2000);
                    WebSocketMessageModule<Long> module = new WebSocketMessageModule<>();
                    module.setOp(1);
                    module.setD(Cache.lastMessageId);
                    client.send(XJson.toJsonString(module));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        task.start();
    }

    public void end(){
        task.interrupt();
    }
}
