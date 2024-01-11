package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2023/9/29 17:38
 * @Author: Virus_Cui
 */
@Data
public class MessageEmbed {
    private String title;
    private String prompt;
    private MessageEmbedThumbnail thumbnail;
    private List<MessageEmbedField> fields;
}
