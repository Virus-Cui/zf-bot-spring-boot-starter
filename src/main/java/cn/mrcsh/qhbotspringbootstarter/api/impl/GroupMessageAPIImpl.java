package cn.mrcsh.qhbotspringbootstarter.api.impl;

import cn.mrcsh.qhbotspringbootstarter.api.GroupMessageAPI;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.GroupMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.InitiativeMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.MediaMessage;
import com.alibaba.fastjson2.JSONObject;

/**
 * @Date: 2024/1/6 10:26
 * @Author: Virus_Cui,BaiShenYao_Dog
 */
public class GroupMessageAPIImpl implements GroupMessageAPI {
    @Override
    public void sendMessage(GroupMessage message, InitiativeMessage initiativeMessage) {
        String url = String.format("/v2/groups/%s/messages", message.getGroup_openid());
        initiativeMessage.setMsg_id(message.getId());
        XHttp.post(url, XJson.toJsonString(initiativeMessage));
    }
}
