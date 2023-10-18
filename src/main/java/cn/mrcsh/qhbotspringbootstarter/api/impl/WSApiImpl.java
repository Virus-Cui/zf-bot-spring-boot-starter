package cn.mrcsh.qhbotspringbootstarter.api.impl;

import cn.mrcsh.qhbotspringbootstarter.api.WSApi;
import cn.mrcsh.qhbotspringbootstarter.utils.XHttp;
import cn.mrcsh.qhbotspringbootstarter.utils.XJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Date: 2023/9/28 9:34
 * @Author: Virus_Cui
 */
@Service

public class WSApiImpl implements WSApi {


    Logger logger = LoggerFactory.getLogger(WSApiImpl.class);

    /**
     * 获取Wss接口URL
     * @return URL
     */
    @Override
    public String getWssEndpoint() {
        String json = XHttp.get("/gateway");
        return XJson.of(json).get("url").asText();
    }

    @Override
    public String getPartWssEndpoint() {
        return null;
    }
}
