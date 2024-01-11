package cn.mrcsh.qhbotspringbootstarter.api;

/**
 * @Date: 2023/9/28 9:33
 * @Author: Virus_Cui
 */

/**
 * WebsocketAPI实现
 */
public interface WSApi {
    /**
     * 获取Wss接口URL
     * @return URL
     */
    String getWssEndpoint();

    String getPartWssEndpoint();
}
