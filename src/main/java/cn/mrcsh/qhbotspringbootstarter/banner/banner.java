package cn.mrcsh.qhbotspringbootstarter.banner;

import cn.mrcsh.qhbotspringbootstarter.annotation.EventHandler;
import cn.mrcsh.qhbotspringbootstarter.annotation.QHBot;
import cn.mrcsh.qhbotspringbootstarter.config.Cache;
import cn.mrcsh.qhbotspringbootstarter.config.Const;
import cn.mrcsh.qhbotspringbootstarter.config.QQBotProperty;
import cn.mrcsh.qhbotspringbootstarter.module.EventMethodModule;
import cn.mrcsh.qhbotspringbootstarter.module.enums.EventTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Map;

/**
 * @Date: 2023/9/27 18:23
 * @Author: Virus_Cui
 */
@Component
public class banner {

    @Autowired
    private QQBotProperty property;

    @Autowired
    private ApplicationContext context;

    public final String banner = "======================================================\n" +
            "                                                      \n" +
            " _____ _____    _____                       _     _   \n" +
            "|__   |   __|  |   __|___ ___ ___ ___ _ _ _|_|___| |_ \n" +
            "|   __|   __|  |   __|  _| .'|   | -_| | | | |  _| '_|\n" +
            "|_____|__|     |__|  |_| |__,|_|_|___|_____|_|_| |_,_|\n" +
            "Author: Virus_Cui\n" +
            "环境: %s\n\n" +
            "======================================================\n";

    @PostConstruct
    public void send() {
        // 初始化参数
        initialize();
        // 打印Banner
        System.out.printf((banner) + "%n", property.isDev() ? "开发环境" : "生产环境");
    }

    public void initialize(){
        Const.baseURL = property.isDev() ? "https://sandbox.api.sgroup.qq.com" : "https://api.sgroup.qq.com";
        Const.token = String.format("Bot %s.%s", property.getBotAppId(), property.getBotToken());
        Const.heartLog = property.isHeartbeat();
        Const.intents = property.getIntents();
        mappingMethods();
    }

    public void mappingMethods() {
        Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(QHBot.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            for (Method method : entry.getValue().getClass().getDeclaredMethods()) {
                EventHandler annotation = method.getAnnotation(EventHandler.class);
                if (annotation != null) {
                    for (Parameter parameter : method.getParameters()) {
                        if (EventTypes.isHas(parameter.getType()) != null) {
                            Cache.methodMapping.computeIfAbsent(parameter.getType().getName(), k -> new ArrayList<>());
                            EventMethodModule methodModule = new EventMethodModule();
                            methodModule.setMethod(method);
                            methodModule.setObj(entry.getValue());
                            Cache.methodMapping.get(parameter.getType().getName()).add(methodModule);
                            break;
                        }
                        break;
                    }
                }
            }

        }
    }
}
