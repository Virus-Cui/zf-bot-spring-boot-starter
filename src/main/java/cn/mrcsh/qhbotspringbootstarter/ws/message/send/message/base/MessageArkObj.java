package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2023/9/29 17:43
 * @Author: Virus_Cui
 */
@Data
public class MessageArkObj {
    private List<MessageArkObjKv> obj_kv;
}
