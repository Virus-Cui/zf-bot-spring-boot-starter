package cn.mrcsh.qhbotspringbootstarter.events;

import cn.mrcsh.qhbotspringbootstarter.utils.ReflectUtil;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.Message;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;

/**
 * @Date: 2023/9/28 14:53
 * @Author: Virus_Cui
 */
public abstract class AbstractEvent {
    public abstract void send(BaseMessage message);

    public BaseMessage copyValue(BaseMessage from, BaseMessage to) throws IllegalAccessException {
        ReflectUtil.copyProperties(from, to);
        return to;
    }
}
