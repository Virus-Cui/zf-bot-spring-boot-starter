package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base;

import lombok.Data;

/**
 * @Date: 2023/9/29 17:38
 * @Author: Virus_Cui
 */
@Data
public class MessageReference {
    private String message_id;
    private boolean ignore_get_message_error;
}
