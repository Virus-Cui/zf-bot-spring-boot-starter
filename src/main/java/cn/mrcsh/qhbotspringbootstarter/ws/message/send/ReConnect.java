package cn.mrcsh.qhbotspringbootstarter.ws.message.send;

import lombok.Data;

/**
 * @Date: 2023/9/28 17:11
 * @Author: Virus_Cui
 */
@Data
public class ReConnect {
    private String token;
    private String session_id;
    private Long seq;
}
