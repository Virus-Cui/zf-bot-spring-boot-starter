package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base;

import lombok.Data;

/**
 * @Date: 2023/9/29 17:38
 * @Author: Virus_Cui
 */
@Data
public class MessageArk {
    private Integer template_id;
    private MessageArkKv kv;
}
