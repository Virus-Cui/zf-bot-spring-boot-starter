package cn.mrcsh.qhbotspringbootstarter.ws.message.receive;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2023/9/28 17:07
 * @Author: Virus_Cui
 */
@Data
public class BotInfo {
    private Integer version;
    private String session_id;
    private user user;
    private List<Integer> shard;

    @Data
    public class user {
        private String id;
        private String username;
        private boolean bot;
    }
}
