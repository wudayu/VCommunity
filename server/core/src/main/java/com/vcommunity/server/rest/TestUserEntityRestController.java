package com.vcommunity.server.rest;

import com.vcommunity.server.entity.TestUserEntity;
import com.vcommunity.server.mapper.BeanMapper;
import com.vcommunity.server.metrics.MetricRegistry;
import com.vcommunity.server.metrics.Timer;
import com.vcommunity.server.rest.dto.TestUserEntityDTO;
import com.vcommunity.server.service.TestUserEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Controller
@RequestMapping(value = { "/api/v1/user", "/api/secure/v1/user" })
public class TestUserEntityRestController {

    private static Logger logger = LoggerFactory.getLogger(TestUserEntityRestController.class);

    private TestUserEntityService testUserEntityService;

    private Timer executionMetrics;

    @PostConstruct
    public void register() {
        executionMetrics = MetricRegistry.INSTANCE.timer("REST.GetUser");
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody Message getUser(@PathVariable("id") String uuid) {
        final Timer.TimerContext executionTimer = executionMetrics.start();

        try {
            TestUserEntity testUserEntity = testUserEntityService.findUserByJpa(uuid);
            Message rtnMessage = new Message();

            if (null == testUserEntity) {
                String message = "Could not find the user by uuid : " + uuid;
                logger.warn(message);
                rtnMessage.setMessage(message);
                rtnMessage.setSuccess(false);
                throw new RestException(HttpStatus.NOT_FOUND, message);
            }

            TestUserEntityDTO userEntityDTO = BeanMapper.map(testUserEntity, TestUserEntityDTO.class);
            rtnMessage.setData(userEntityDTO);
            rtnMessage.setSuccess(true);
            rtnMessage.setMessageType(Message.MESSAGE_TYPE_NORMAL);
            rtnMessage.setMessage("Get userEntity success.");
            return rtnMessage;
        } finally {
            executionTimer.stop();
        }
    }

    @RequestMapping(value = "")
    public @ResponseBody Message findAllUser() {
        final Timer.TimerContext executionTimer = executionMetrics.start();

        try {
            List<TestUserEntity> list = testUserEntityService.findAllByJpa();
            Message rtnMessage = new Message();

            List<TestUserEntityDTO> userEntityDTO = BeanMapper.mapList(list, TestUserEntityDTO.class);
            rtnMessage.setData(userEntityDTO);
            rtnMessage.setSuccess(true);
            rtnMessage.setMessageType(Message.MESSAGE_TYPE_NORMAL);
            rtnMessage.setMessage("Get userEntity success.");
            return rtnMessage;
        } finally {
            executionTimer.stop();
        }
    }


    public TestUserEntityService getTestUserEntityService() {
        return testUserEntityService;
    }

    @Autowired
    public void setTestUserEntityService(TestUserEntityService testUserEntityService) {
        this.testUserEntityService = testUserEntityService;
    }
}
