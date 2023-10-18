package cn.mrcsh.qhbotspringbootstarter.api;

import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.Channel;

import java.util.List;

/**
 * @Date: 2023/10/8 10:03
 * @Author: Virus_Cui
 */
public interface ChannelAPI {
    List<Channel> getChannels(String guildId);

    Channel getChannel(String channelId);

    void createChannel(Channel channel);

    void updateChannel(Channel channel);


}
