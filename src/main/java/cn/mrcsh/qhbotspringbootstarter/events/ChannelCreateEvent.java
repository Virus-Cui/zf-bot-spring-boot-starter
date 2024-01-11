package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.Channel;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Date: 2023/10/8 8:55
 * @Author: Virus_Cui
 * 子频道创建事件
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChannelCreateEvent extends AbstractEvent{

    private Channel channel;

    @Override
    public void send(BaseMessage message) {

    }
}
