package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message;

import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base.BaseMessage;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Date: 2024/1/6 10:26
 * @Author: Virus_Cui,BaiShenYao_Dog
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InitiativeMessage extends BaseMessage {
    private String content;
    private Integer msg_type;
    private Integer msg_seq = 1;
    private JSONObject media;
}
