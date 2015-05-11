package com.vcommunity.server.core.service;

import com.vcommunity.server.core.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 业务日志的处理
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Component
public class BusinessLogger {

    public static final String BUSSINESS_LOGGER_NAME = "business";

    private Logger businessLogger = LoggerFactory.getLogger(BUSSINESS_LOGGER_NAME);
    private JsonMapper jsonMapper = new JsonMapper();

    public void log(String entity, String action, String user, Map data) {
        String json = (data != null ? jsonMapper.toJson(data) : "{}");
        businessLogger.info("{},{},{},{}", entity, action, user, json);
    }
}