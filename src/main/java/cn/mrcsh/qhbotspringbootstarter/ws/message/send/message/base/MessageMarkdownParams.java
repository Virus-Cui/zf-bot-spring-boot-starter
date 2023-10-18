package cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.base;

import lombok.Data;

import java.util.List;

/**
 * @Date: 2023/9/29 17:45
 * @Author: Virus_Cui
 */
@Data
public class MessageMarkdownParams {
    private String key;
    private List<String> values;
}
