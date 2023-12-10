package cn.mrcsh.qhbotspringbootstarter.config;

import cn.mrcsh.qhbotspringbootstarter.module.EventMethodModule;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.BotInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2023/9/28 10:49
 * @Author: Virus_Cui
 */
public class Cache {
    // 最后一个信息的id
    public static Long lastMessageId = null;
    public static Map<String, List<EventMethodModule>> methodMapping = new LinkedHashMap<>();
    public static BotInfo botInfo = null;

    public static QQBotProperty property = null;
}
