package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base;

import lombok.Data;

/**
 * @Date: 2023/9/29 17:38
 * @Author: Virus_Cui
 */
@Data
public class MessageMarkdown {
    private Integer template_id;
    private String custom_template_id;
    private MessageMarkdownParams params;
    private String content;
}
