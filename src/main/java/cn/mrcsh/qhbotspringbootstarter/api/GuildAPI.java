package cn.mrcsh.qhbotspringbootstarter.api;

import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.Guild;

/**
 * @Date: 2023/10/8 9:50
 * @Author: Virus_Cui
 */
public interface GuildAPI {
    Guild getGuild(String guildId);
}
