package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message;

import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;

/**
 * @Date: 2023/9/29 17:36
 * @Author: Virus_Cui
 * 基本消息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PlainMessage extends BaseMessage {

    private static PlainMessage instance;
    public static MessageBuilder builder(){
        instance = new PlainMessage();
        return new MessageBuilder();
    }

       public static class MessageBuilder{

        public BaseMessage build(){
            return instance;
        }

        public MessageBuilder appendText(String msg){
            instance.setContent(instance.getContent()==null?msg:"\n"+msg);
            return this;
        }

        public MessageBuilder appendImage(String url){
            instance.setImage(url);
            return this;
        }
    }
}
