package cn.mrcsh.qhbotspringbootstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Date: 2023/9/27 18:35
 * @Author: Virus_Cui
 */
@ConfigurationProperties(prefix = "zfbot")
@Configuration
@Data
public class QQBotProperty {
    /**
     * 对应BotAppID
     */
    private String BotAppId;
    /**
     * 对应机器人令牌
     */
    private String BotToken;
    /**
     * 对应机器人密钥
     */
    private String BotSecretKey;
    /**
     * 是否是沙箱环境
     */
    private boolean dev;
    /**
     * 是否开启心跳包日志
     */
    private boolean heartbeat;
    /**
     * 订阅事件 73509350639274
     */
    private int intents;
}
