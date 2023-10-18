package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.BotInfo;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import com.alibaba.fastjson.JSON;

/**
 * @Date: 2023/10/10 11:23
 * @Author: Virus_Cui
 */
public class BotLoginSuccessfulEvent extends AbstractEvent{

    @Override
    public void send(BaseMessage message) {

    }

    public String getBotId(){
        return Cache.botInfo.getUser().getId();
    }

    public BotInfo getBotInfo(){
        return Cache.botInfo;
    }


}
