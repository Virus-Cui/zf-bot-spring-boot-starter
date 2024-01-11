package cn.mrcsh.qhbotspringbootstarter.ws.message.receive;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2023/10/8 9:21
 * @Author: Virus_Cui
 */
@Data
public class Member {
    private String guild_id;
    private String joined_at;
    private String nick;
    private String op_user_id;
    private List<String> roles;
    private User user;


    @Data
    public class User{
        private String avatar;
        private boolean bot;
        private String id;
        private String username;
    }
}
