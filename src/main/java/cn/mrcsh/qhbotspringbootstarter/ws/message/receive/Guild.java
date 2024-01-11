package cn.mrcsh.qhbotspringbootstarter.ws.message.receive;

import lombok.Data;

/**
 * @Date: 2023/10/8 8:39
 * @Author: Virus_Cui
 */
@Data
public class Guild {
    private String description;
    private String icon;
    private String id;
    private String joined_at;
    private Integer max_members;
    private String member_count;
    private String name;
    private String op_user_id;
    private String owner_id;
}
