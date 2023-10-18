package cn.mrcsh.qhbotspringbootstarter.ws.message.receive;

import lombok.Data;

/**
 * @Date: 2023/10/8 8:59
 * @Author: Virus_Cui
 */
@Data
public class Channel {
    private String guild_id;
    private String id;
    private String name;
    private String op_user_id;
    private String owner_id;
    private Integer sub_type;
    private Integer type;
}
