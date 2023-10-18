package cn.mrcsh.qhbotspringbootstarter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2023/9/27 18:28
 * @Author: Virus_Cui
 */
@Configuration
@ComponentScan("cn.mrcsh.qhbotspringbootstarter")
@EnableConfigurationProperties
public class BaseConfig {

}
