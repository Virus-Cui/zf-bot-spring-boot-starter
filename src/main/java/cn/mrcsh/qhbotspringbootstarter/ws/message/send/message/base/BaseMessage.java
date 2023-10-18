package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base;

import lombok.Data;

import java.io.File;

/**
 * @Date: 2023/9/29 17:36
 * @Author: Virus_Cui
 * 发送消息的对象
 */
@Data
public class BaseMessage {
    /**
     * 要回复的消息id(<a href="https://bot.q.qq.com/wiki/develop/api/openapi/message/model.html#message">Message</a>.id), 在 <a href="https://bot.q.qq.com/wiki/develop/api/gateway/message.html">AT_CREATE_MESSAGE</a> 事件中获取
     */
    public String msg_id;
    /**
     * 要回复的事件id, 在各事件对象中获取
     */
    public String event_id;
    /**
     * 消息内容，文本内容，支持 <a href="https://bot.q.qq.com/wiki/develop/api/openapi/message/message_format.html">内嵌格式</a>
     */
    public String content;
    /**
     * 引用消息
     */
    public MessageReference message_reference;
    /**
     * embed 消息，一种特殊的 ark，详情参考<a href="https://bot.q.qq.com/wiki/develop/api/openapi/message/embed_message.html">Embed消息</a>
     */
    private MessageEmbed embed;
    /**
     * ark 消息
     */
    private MessageArk ark;
    /**
     * 图片url地址，平台会转存该图片，用于下发图片消息
     */
    private String image;
    /**
     * markdown 消息
     */
    private MessageMarkdown markdown;
    /**
     * 表单图片数据
     */
    private File form_data_image;
}
