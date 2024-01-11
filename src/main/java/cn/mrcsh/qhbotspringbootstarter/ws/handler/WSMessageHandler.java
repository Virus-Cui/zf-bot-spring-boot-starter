package cn.mrcsh.qhbotspringbootstarter.ws.handler;

import cn.mrcsh.qhbotspringbootstarter.ws.handler.handlers.*;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 12:44
 * @Author: Virus_Cui
 */
public enum WSMessageHandler {
    DISPATCH(0,"服务端进行消息推送",new DispatchHandler()),
    HEARTBEAT(1,"客户端或服务端发送心跳",new HeartbeatHandler()),
    IDENTIFY(2,"客户端发送鉴权",new DefaultHandler()),
    RESUME(6,"客户端恢复连接",new ResumeHandler()),
    RECONNECT(7,"服务端通知客户端重新连接",new ReconnectHandler()),
    INVALID_SESSION(9,"当identify或resume的时候，如果参数有错，服务端会返回该消息",new DefaultHandler()),
    HELLO(10,"当客户端与网关建立ws连接之后，网关下发的第一条消息",new HelloHandler()),
    HEARTBEAT_ACK(11,"当发送心跳成功之后，就会收到该消息",new HeartbeatAckHandler()),
    HTTP_CALLBACK_ACK(12,"仅用于 http 回调模式的回包，代表机器人收到了平台推送的数据",new DefaultHandler()),
    DEFAULT(-1,"没有命中，抛出异常",new DefaultHandler());

    private Integer code;
    private String desc;
    private AbstractMessageHandler messageHandler;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public AbstractMessageHandler getMessageHandler() {
        return messageHandler;
    }

    WSMessageHandler(Integer code, String desc, AbstractMessageHandler messageHandler) {
        this.code = code;
        this.desc = desc;
        this.messageHandler = messageHandler;
    }

    public static void hand(String message, WebSocketClient webSocketClient){
        Integer code = XJson.of(message).get("op").asInt();
        for (WSMessageHandler value : WSMessageHandler.values()) {
            if(code.equals(value.code)){
                value.messageHandler.hand(message, webSocketClient);
                return;
            }
        }
        WSMessageHandler.DEFAULT.messageHandler.hand(message, webSocketClient);
    }
}
