package cn.mrcsh.qhbotspringbootstarter.module;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Date: 2023/9/28 15:00
 * @Author: Virus_Cui
 */
@Data
public class EventMethodModule {
    private Object obj;
    private Method method;
}
