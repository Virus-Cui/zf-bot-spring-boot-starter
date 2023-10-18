package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.Guild;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Date: 2023/10/8 8:37
 * @Author: Virus_Cui
 * 频道移除事件
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GuildDeleteEvent extends AbstractEvent {

    private Guild guild;

    @Override
    public void send(BaseMessage message) {

    }
}
