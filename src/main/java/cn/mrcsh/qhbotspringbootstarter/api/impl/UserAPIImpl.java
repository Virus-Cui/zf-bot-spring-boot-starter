package cn.mrcsh.qhbotspringbootstarter.api.impl;

import cn.mrcsh.qhbotspringbootstarter.api.UserAPI;
import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.Guild;
import cn.mrcsh.qhbotspringbootstarter.module.apimoudle.User;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import com.alibaba.fastjson2.JSON;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date: 2023/10/8 9:36
 * @Author: Virus_Cui
 */
@Service
public class UserAPIImpl implements UserAPI {

    @Override
    public User getUserInfo() {
        String s = XHttp.get("/users/@me");
        return JSON.parseObject(s, User.class);
    }

    @Override
    public List<Guild> getGuilds() {
        String s = XHttp.get("/users/@me/guilds");
        return JSON.parseArray(s, Guild.class);
    }
}
