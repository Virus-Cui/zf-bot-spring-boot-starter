package cn.mrcsh.qhbotspringbootstarter.api.impl;

import cn.mrcsh.qhbotspringbootstarter.api.GroupMessageAPI;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.GroupMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.InitiativeMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.MediaMessage;

/**
 * @Date: 2023/11/12 10:48
 * @Author: Virus_Cui
 */
public class GroupMessageAPIImpl implements GroupMessageAPI {
    @Override
    public void sendMessage(GroupMessage message, InitiativeMessage initiativeMessage) {
        String url = String.format("/v2/groups/%s/messages", message.getGroup_openid());
        initiativeMessage.setMsg_id(message.getId());
        String post = XHttp.post(url, XJson.toJsonString(initiativeMessage));
    }

    @Override
    public void sendMedia(GroupMessage message, InitiativeMessage initiativeMessage) {
        MediaMessage mediaMessage = new MediaMessage();
        mediaMessage.setFile_type("1");
        mediaMessage.setUrl(initiativeMessage.getImage());
        XHttp.post(String.format("/v2/groups/%s/files", message.getGroup_openid()),XJson.toJsonString(mediaMessage));
    }
}
