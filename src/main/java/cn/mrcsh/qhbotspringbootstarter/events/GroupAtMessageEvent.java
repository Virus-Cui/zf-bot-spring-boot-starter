package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.api.GroupMessageAPI;
import cn.mrcsh.qhbotspringbootstarter.api.impl.GroupMessageAPIImpl;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.GroupMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.InitiativeMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Date: 2023/11/8 9:57
 * @Author: Virus_Cui
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupAtMessageEvent extends AbstractEvent<InitiativeMessage> {
    private GroupMessage message;

    @Override
    public void send(InitiativeMessage initiativeMessage) {
        GroupMessageAPI groupMessageAPI = new GroupMessageAPIImpl();
        if(initiativeMessage.getContent() != null){
            groupMessageAPI.sendMessage(message, initiativeMessage);
        }else if(initiativeMessage.getImage() != null){
            groupMessageAPI.sendMedia(message, initiativeMessage);
        }else {
            groupMessageAPI.sendMessage(message, initiativeMessage);
            groupMessageAPI.sendMedia(message, initiativeMessage);

        }
    }
}
