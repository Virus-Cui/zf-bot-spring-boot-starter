package cn.mrcsh.qhbotspringbootstarter.module.enums;

/**
 * @Date: 2023/10/8 10:12
 * @Author: Virus_Cui
 */
public enum ChannelType {
    TEXT(0,"文字子频道"),
    VOICE(2,"语音子频道"),
    GROUP(4,"子频道分组"),
    LIVE(10005,"直播子频道"),
    APPLICATION(10006,"应用子频道"),
    BBS(10007,"论坛子频道")
    ;
    private Integer type;
    private String desc;

    ChannelType(Integer type, String desc) {
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
