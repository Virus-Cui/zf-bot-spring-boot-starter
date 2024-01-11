package cn.mrcsh.qhbotspringbootstarter.module.apimoudle;

import cn.hutool.extra.ssh.ChannelType;
import lombok.Data;

/**
 * @Date: 2023/10/8 9:59
 * @Author: Virus_Cui
 */
@Data
public class Channel {
    private String id;
    private String guild_id;
    private String name;
    private String type;
    private String sub_type;
    private String position;
    private String parent_id;
    private String owner_id;
    private String private_type;
    private String speak_permission;
    private String application_id;
    private String permissions;
}
