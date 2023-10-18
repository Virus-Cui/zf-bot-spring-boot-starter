package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.Message;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.MessageReference;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import org.java_websocket.client.WebSocketClient;

/**
 * @Date: 2023/9/28 14:26
 * @Author: Virus_Cui
 * 普通消息事件
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageEvent extends AbstractEvent{
    private Message data;
    private WebSocketClient client;
    @SneakyThrows
    public void replay(BaseMessage message){
        BaseMessage xMessage = copyValue(message, new BaseMessage());
        MessageReference messageReference = new MessageReference();
        messageReference.setMessage_id(xMessage.getMsg_id());
        xMessage.setMessage_reference(messageReference);
        String post = XHttp.post(String.format(Const.SEND_MESSAGE_URL, data.getChannel_id()), JSON.toJSONString(xMessage));
    }

    @Override
    @SneakyThrows
    public void send(BaseMessage message) {
        BaseMessage xMessage = copyValue(message, new BaseMessage());
        XHttp.post(String.format(Const.SEND_MESSAGE_URL,data.getChannel_id()),JSON.toJSONString(xMessage));
    }
}
