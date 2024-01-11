package cn.mrcsh.qhbotspringbootstarter.ws.handler.handlers;

import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.events.*;
import cn.mrcsh.qhbotspringbootstarter.module.EventMethodModule;
import cn.mrcsh.qhbotspringbootstarter.module.enums.EventTypes;
import cn.mrcsh.qhbotspringbootstarter.module.WebSocketMessageModule;
import cn.mrcsh.qhbotspringbootstarter.ws.handler.AbstractMessageHandler;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.*;
import cn.mrcsh.qhbotspringbootstarter.ws.task.KeepAliveTask;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.java_websocket.client.WebSocketClient;

import java.util.List;

/**
 * @Date: 2023/9/28 12:47
 * @Author: Virus_Cui
 */
public class DispatchHandler extends AbstractMessageHandler {
    @Override
    public void hand(String s, WebSocketClient webSocketClient) {
        String type = XJson.of(s).get("t").asText();
        Object data = null;
        switch (type) {
            case "READY":
                new KeepAliveTask().start(webSocketClient);
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<BotInfo>>() {
                });
                WebSocketMessageModule<BotInfo> botinfo = (WebSocketMessageModule<BotInfo>) data;
                Cache.botInfo = botinfo.getD();
                BotLoginSuccessfulEvent botLoginSuccessfulEvent = new BotLoginSuccessfulEvent();
                invokeEvent(type, botLoginSuccessfulEvent);
                break;
            case "AT_MESSAGE_CREATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Message>>() {
                });
                WebSocketMessageModule<Message> module = (WebSocketMessageModule<Message>) data;
                ATMessageEvent event = new ATMessageEvent();
                event.setData(module.getD());
                event.getData().setEventId(module.getId());
                invokeEvent(type, event);
                break;
            case "MESSAGE_CREATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Message>>() {
                });
                WebSocketMessageModule<Message> messageModule = (WebSocketMessageModule<Message>) data;
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setData(messageModule.getD());
                messageEvent.getData().setEventId(messageModule.getId());
                messageEvent.setClient(webSocketClient);
                invokeEvent(type, messageEvent);
                break;
            case "GUILD_CREATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Guild>>() {
                });
                WebSocketMessageModule<Guild> createGuild = (WebSocketMessageModule<Guild>) data;
                GuildCreateEvent guildCreateEvent = new GuildCreateEvent();
                guildCreateEvent.setGuild(createGuild.getD());
                invokeEvent(type, guildCreateEvent);
                break;
            case "GUILD_UPDATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Guild>>() {
                });
                WebSocketMessageModule<Guild> updateGuild = (WebSocketMessageModule<Guild>) data;
                GuildUpdateEvent guildUpdateEvent = new GuildUpdateEvent();
                guildUpdateEvent.setGuild(updateGuild.getD());
                invokeEvent(type, guildUpdateEvent);
                break;
            case "GUILD_DELETE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Guild>>() {
                });
                WebSocketMessageModule<Guild> deleteGuild = (WebSocketMessageModule<Guild>) data;
                GuildDeleteEvent guildDeleteEvent = new GuildDeleteEvent();
                guildDeleteEvent.setGuild(deleteGuild.getD());
                invokeEvent(type, guildDeleteEvent);
                break;
            case "CHANNEL_CREATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Channel>>() {
                });
                WebSocketMessageModule<Channel> createChannel = (WebSocketMessageModule<Channel>) data;
                ChannelCreateEvent channelCreateEvent = new ChannelCreateEvent();
                channelCreateEvent.setChannel(createChannel.getD());
                invokeEvent(type, channelCreateEvent);
                break;
            case "CHANNEL_UPDATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Channel>>() {
                });
                WebSocketMessageModule<Channel> updateChannel = (WebSocketMessageModule<Channel>) data;
                ChannelUpdateEvent channelUpdateEvent = new ChannelUpdateEvent();
                channelUpdateEvent.setChannel(updateChannel.getD());
                invokeEvent(type, channelUpdateEvent);
                break;
            case "CHANNEL_DELETE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Channel>>() {
                });
                WebSocketMessageModule<Channel> deleteChannel = (WebSocketMessageModule<Channel>) data;
                ChannelDeleteEvent channelDeleteEvent = new ChannelDeleteEvent();
                channelDeleteEvent.setChannel(deleteChannel.getD());
                invokeEvent(type, channelDeleteEvent);
                break;
            case "GUILD_MEMBER_ADD":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Member>>() {
                });
                WebSocketMessageModule<Member> addMember = (WebSocketMessageModule<Member>) data;
                GuildMemberAddEvent guildMemberAddEvent = new GuildMemberAddEvent();
                guildMemberAddEvent.setMember(addMember.getD());
                invokeEvent(type, guildMemberAddEvent);
                break;
            case "GUILD_MEMBER_UPDATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Member>>() {
                });
                WebSocketMessageModule<Member> updateMember = (WebSocketMessageModule<Member>) data;
                GuildMemberUpdateEvent guildMemberAddEvent1 = new GuildMemberUpdateEvent();
                guildMemberAddEvent1.setMember(updateMember.getD());
                invokeEvent(type, guildMemberAddEvent1);
                break;
            case "GUILD_MEMBER_REMOVE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Member>>() {
                });
                WebSocketMessageModule<Member> removeMember = (WebSocketMessageModule<Member>) data;
                GuildMemberRemoveEvent guildMemberRemoveEvent = new GuildMemberRemoveEvent();
                guildMemberRemoveEvent.setMember(removeMember.getD());
                invokeEvent(type, guildMemberRemoveEvent);
                break;
            case "DIRECT_MESSAGE_CREATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<Message>>() {
                });
                WebSocketMessageModule<Message> directMessage = (WebSocketMessageModule<Message>) data;
                DirectMessageEvent directMessageEvent = new DirectMessageEvent();
                directMessageEvent.setMessage(directMessage.getD());
                invokeEvent(type, directMessageEvent);
                break;
            case "GROUP_AT_MESSAGE_CREATE":
                data = JSON.parseObject(s, new TypeReference<WebSocketMessageModule<GroupMessage>>() {
                });
                WebSocketMessageModule<GroupMessage> groupMessage = (WebSocketMessageModule<GroupMessage>) data;
                GroupAtMessageEvent groupAtMessageEvent = new GroupAtMessageEvent();
                groupAtMessageEvent.setMessage(groupMessage.getD());
                invokeEvent(type, groupAtMessageEvent);
                break;
            default:
                System.out.println("null");
                break;
        }
    }


    public void invokeEvent(String type, AbstractEvent event) {
        try {
            List<EventMethodModule> atMessageCreate = Cache.methodMapping.get(EventTypes.getType(type));
            if (atMessageCreate != null) {
                for (EventMethodModule methodModule : atMessageCreate) {
                    methodModule.getMethod().invoke(methodModule.getObj(), event);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
