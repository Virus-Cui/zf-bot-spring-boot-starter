package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message;

import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Date: 2023/11/8 10:13
 * @Author: Virus_Cui
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InitiativeMessage extends BaseMessage {
    private String content;
    private Integer message_type;
}
