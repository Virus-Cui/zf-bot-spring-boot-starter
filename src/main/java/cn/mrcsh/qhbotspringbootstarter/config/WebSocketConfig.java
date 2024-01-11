package cn.mrcsh.qhbotspringbootstarter.config;

import cn.mrcsh.qhbotspringbootstarter.api.WSApi;
import cn.mrcsh.qhbotspringbootstarter.ws.TXWebSocketClient;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * @Date: 2023/9/28 9:26
 * @Author: Virus_Cui
 */
@Configuration
@Slf4j
public class WebSocketConfig {
    @Autowired
    private WSApi wsApi;

    @Bean
    public WebSocketClient webSocketClient(){
        try {
            String endpoint = wsApi.getWssEndpoint();
            log.info("连接websocket服务,URL: '{}'",endpoint);
            TXWebSocketClient webSocketClient = new TXWebSocketClient(new URI(endpoint));
            webSocketClient.connect();
            log.info("连接websocket服务成功:success");

            return webSocketClient;
        }catch (Exception e){
            log.error("连接websocket服务失败，实时消息功能失效",e);
        }
        return null;
    }
}
