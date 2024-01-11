package cn.mrcsh.qhbotspringbootstarter.ws.message.receive;

import lombok.Data;

/**
 * @Date: 2023/11/8 9:54
 * @Author: Virus_Cui
 */
@Data
public class GroupMessage {

    private Author author;
    private String content;
    private String group_id;
    private String group_openid;
    private String id;
    private String timestamp;

    @Data
    public static class Author{
        private String id;
        private String member_openid;
    }
}
