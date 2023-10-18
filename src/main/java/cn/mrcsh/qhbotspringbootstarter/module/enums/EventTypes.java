package cn.mrcsh.qhbotspringbootstarter.module.enums;

import cn.mrcsh.qhbotspringbootstarter.events.*;

/**
 * @Date: 2023/9/28 14:53
 * @Author: Virus_Cui
 */
public enum EventTypes {
    READY("READY", BotLoginSuccessfulEvent.class),
    AT_MESSAGE("AT_MESSAGE_CREATE",ATMessageEvent.class),
    MESSAGE("MESSAGE_CREATE", MessageEvent.class),
    GUILD_CREATE("GUILD_CREATE", GuildCreateEvent.class),
    GUILD_UPDATE("GUILD_UPDATE", GuildUpdateEvent.class),
    GUILD_DELETE("GUILD_DELETE", GuildDeleteEvent.class),
    CHANNEL_CREATE("CHANNEL_CREATE", ChannelCreateEvent.class),
    CHANNEL_UPDATE("CHANNEL_UPDATE", ChannelUpdateEvent.class),
    CHANNEL_DELETE("CHANNEL_DELETE", ChannelDeleteEvent.class),
    GUILD_MEMBER_ADD("GUILD_MEMBER_ADD", GuildMemberAddEvent.class),
    GUILD_MEMBER_UPDATE("GUILD_MEMBER_UPDATE", GuildMemberUpdateEvent.class),
    GUILD_MEMBER_REMOVE("GUILD_MEMBER_REMOVE", GuildMemberRemoveEvent.class),
    DIRECT_MESSAGE_CREATE("DIRECT_MESSAGE_CREATE", DirectMessageEvent.class),
    ;

    public String getName() {
        return name;
    }

    public Class<? extends AbstractEvent> getEvent() {
        return event;
    }

    EventTypes(String name, Class<? extends AbstractEvent> event) {
        this.name = name;
        this.event = event;
    }

    private String name;
    private Class<? extends AbstractEvent> event;

    public static String getType(String type){
        for (EventTypes value : EventTypes.values()) {
            if (value.name.equals(type)) {
                return value.event.getName();
            }
        }
        return null;
    }

    public static String isHas(Class<?> clazz){
        for (EventTypes value : EventTypes.values()) {
            if (value.event.equals(clazz)) {
                return value.name;
            }
        }
        return null;
    }
}
