package cn.mrcsh.qhbotspringbootstarter.module.enums;

/**
 * @Date: 2023/10/8 10:15
 * @Author: Virus_Cui
 */
public enum ChannelSubType {
    CHAT(0,"闲聊"),
    NOTICE(1,"公告"),
    INTRODUCTION(2,"攻略"),
    BLACKOUT(3,"开黑"),
    ;
    private Integer type;
    private String desc;

    ChannelSubType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
