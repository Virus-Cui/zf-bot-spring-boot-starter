package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.Message;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Date: 2023/10/8 9:32
 * @Author: Virus_Cui
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DirectMessageEvent extends AbstractEvent{
    private Message message;


    @Override
    public void send(BaseMessage message) {

    }
}
