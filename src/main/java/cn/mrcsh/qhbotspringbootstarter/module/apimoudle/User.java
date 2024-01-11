package cn.mrcsh.qhbotspringbootstarter.module.apimoudle;

import lombok.Data;

/**
 * @Date: 2023/10/8 9:38
 * @Author: Virus_Cui
 */
@Data
public class User {
    /**
     * 用户 id
     */
    private String id;
    private String username;
    private String avatar;
    private boolean bot;
    /**
     * 特殊关联应用的 openid，需要特殊申请并配置后才会返回。如需申请，请联系平台运营人员。
     */
    private String union_openid;
    /**
     * 机器人关联的互联应用的用户信息，与union_openid关联的应用是同一个。如需申请，请联系平台运营人员。
     */
    private String union_user_account;
}
