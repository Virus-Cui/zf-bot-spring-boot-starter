package cn.mrcsh.qhbotspringbootstarter.ws.message.send;

import lombok.Data;

/**
 * @Date: 2023/9/28 10:09
 * @Author: Virus_Cui
 */
@Data
public class Identify {
    /**
     * {
     *   "op": 2,
     *   "d": {
     *     "token": "token string",
     *     "intents": 513,
     *     "shard": [0, 4],
     *     "properties": {
     *       "$os": "linux",
     *       "$browser": "my_library",
     *       "$device": "my_library"
     *     }
     *   }
     * }
     */
    private String token;
    private Integer intents;
    private Integer [] shard = {0,1};
}
