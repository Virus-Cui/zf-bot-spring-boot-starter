package cn.mrcsh.qhbotspringbootstarter.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 2023/9/28 9:12
 * @Author: Virus_Cui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebSocketMessageModule<T> {
    // opcode
    private Integer op;
    // 数据
    private T d;
    // 消息ID
    private Long s;
    // 消息类型
    private String t;
    // EventId
    private String id;


}
