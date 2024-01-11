package cn.mrcsh.qhbotspringbootstarter.utils;

import cn.mrcsh.qhbotspringbootstarter.ws.message.receive.GroupMessage;
import cn.mrcsh.qhbotspringbootstarter.ws.message.send.message.MediaMessage;

/**
 * @Date: 2024/1/6 10:26
 * @Author: BaiShenYao_Dog
 */
public class MediaUtil {
    public static String getGroupMedia(GroupMessage message, String URL) {
        MediaMessage mediaMessage = new MediaMessage();
        mediaMessage.setFile_type(1);
        mediaMessage.setUrl(URL);
        return XHttp.post(String.format("/v2/groups/%s/files", message.getGroup_openid()),XJson.toJsonString(mediaMessage));
    }
}
