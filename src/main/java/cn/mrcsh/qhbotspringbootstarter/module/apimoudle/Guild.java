package cn.mrcsh.qhbotspringbootstarter.module.apimoudle;

import lombok.Data;

/**
 * @Date: 2023/10/8 9:41
 * @Author: Virus_Cui
 */
@Data
public class Guild {
    /**
     * 频道ID
     */
    private String id;
    /**
     * 频道名称
     */
    private String name;
    /**
     * 频道头像地址
     */
    private String icon;
    /**
     * 创建人用户ID
     */
    private String owner_id;
    /**
     * 当前人是否是创建人
     */
    private String owner;
    /**
     * 成员数
     */
    private String member_count;
    /**
     * 最大成员数
     */
    private String max_members;
    /**
     * 描述
     */
    private String description;
    /**
     * 加入时间
     */
    private String joined_at;
}
