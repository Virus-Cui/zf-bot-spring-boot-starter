package cn.mrcsh.qhbotspringbootstarter.ws.message.send;

import lombok.Data;

/**
 * @Date: 2023/9/28 10:09
 * @Author: Virus_Cui
 */
@Data
public class Identify {
    private String token;
    private Integer intents;
    private Integer [] shard = {0,1};
}
