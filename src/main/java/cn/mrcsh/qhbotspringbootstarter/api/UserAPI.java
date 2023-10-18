package cn.mrcsh.qhbotspringbootstarter.api;

import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.Guild;
import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.User;

import java.util.List;

/**
 * @Date: 2023/10/8 9:36
 * @Author: Virus_Cui
 */
public interface UserAPI {
    /**
     * 获取当前机器人详情
     * @return 用户对象
     */
    User getUserInfo();

    /**
     * 获取当前机器人频道列表
     */
    List<Guild> getGuilds();

}
