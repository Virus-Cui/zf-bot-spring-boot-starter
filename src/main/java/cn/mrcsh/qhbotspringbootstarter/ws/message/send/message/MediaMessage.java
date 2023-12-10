package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message;

import lombok.Data;

/**
 * @Date: 2023/11/12 10:50
 * @Author: Virus_Cui
 */
@Data
public class MediaMessage {
    private String file_type;
    private String url;
    private boolean srv_send_msg = true;

}
