package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.Member;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Date: 2023/10/8 9:20
 * @Author: Virus_Cui
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GuildMemberAddEvent extends AbstractEvent{

    private Member member;

    @Override
    public void send(BaseMessage message) {

    }
}
