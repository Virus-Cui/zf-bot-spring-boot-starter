package cn.mrcsh.qhbotspringbootstarter.api.impl;

import cn.mrcsh.qhbotspringbootstarter.api.GuildAPI;
import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.Guild;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import com.alibaba.fastjson2.JSON;
import org.springframework.stereotype.Service;

/**
 * @Date: 2023/10/8 9:53
 * @Author: Virus_Cui
 */
@Service
public class GuildAPIImpl implements GuildAPI {

    @Override
    public Guild getGuild(String guildId) {
        String s = XHttp.get(String.format("/guilds/%s", guildId));
        return JSON.parseObject(s, Guild.class);
    }
}
