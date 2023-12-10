package cn.mrcsh.qhbotspringbootstarter.api;

import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.GroupMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.InitiativeMessage;

/**
 * @Date: 2023/11/12 10:47
 * @Author: Virus_Cui
 */
public interface GroupMessageAPI {
    void sendMessage(GroupMessage message, InitiativeMessage initiativeMessage);
    void sendMedia(GroupMessage message, InitiativeMessage initiativeMessage);
}
