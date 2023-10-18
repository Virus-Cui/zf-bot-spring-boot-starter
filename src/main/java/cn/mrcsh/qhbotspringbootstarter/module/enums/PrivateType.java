package cn.mrcsh.qhbotspringbootstarter.module.enums;

/**
 * @Date: 2023/10/8 10:18
 * @Author: Virus_Cui
 */
public enum PrivateType {
    OPEN(0,"公开频道"),
    PRIVATE(1,"群主管理员可见"),
    CUSTOM(2,"群主管理员+指定成员，可使用 修改子频道权限接口 指定成员"),
    ;
    private Integer type;
    private String desc;

    PrivateType(Integer type, String desc) {
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
