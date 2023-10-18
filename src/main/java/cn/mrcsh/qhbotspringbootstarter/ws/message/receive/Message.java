package cn.mrcsh.qhbotspringbootstarter.ws.message.receive;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2023/9/28 11:46
 * @Author: Virus_Cui
 */
@Data
public class Message {

    private author author;
    private String channel_id;
    private String content;
    private String guild_id;
    private String id;
    private member member;
    private List<mention> mentions;
    private Integer seq;
    private String seq_in_channel;
    private String timestamp;
    private String eventId;



    @Data
    public class author{
        private String avatar;
        private boolean bot;
        private String id;
        private String username;
    }

    @Data
    public class member{
        private String joined_at;
        private String nick;
        private List<String> roles;
    }

    @Data
    public class mention{
        private String avatar;
        private boolean bot;
        private String id;
        private String username;
    }

}
