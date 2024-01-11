package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message;

import lombok.Data;

/**
 * @Date: 2024/1/6 10:26
 * @Author: Virus_Cui,BaiShenYao_Dog
 */
@Data
public class MediaMessage {
    private Integer file_type;
    private String url;
    private boolean srv_send_msg = false;
}
