package cn.mrcsh.qhbotspringbootstarter.api;

/**
 * @Date: 2023/11/7 13:22
 * @Author: Virus_Cui
 */
public interface AccessTokenAPI {
    String getAccessToken(String appId, String clintSecret);

}
