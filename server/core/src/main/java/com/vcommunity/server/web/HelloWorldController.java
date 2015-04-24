package com.vcommunity.server.web;

import com.vcommunity.server.entity.TestUserEntity;
import com.vcommunity.server.service.TestUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author James Chow
 * @createdate 2015/4/23
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Controller
@RequestMapping("/index")
public class HelloWorldController {
    private TestUserEntityService testUserEntityService;

    @RequestMapping(value = { "", "/" })
    public @ResponseBody String index(Model model) {
        return "Hello World !!!";
    }

    public TestUserEntityService getTestUserEntityService() {
        return testUserEntityService;
    }

    @Autowired
    public void setTestUserEntityService(TestUserEntityService testUserEntityService) {
        this.testUserEntityService = testUserEntityService;
    }
}
