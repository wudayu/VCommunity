package com.vcommunity.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author James Chow
 * @createdate 2015/4/23
 * @contact zhouxy.vortex@gamil.com
 * @since v1.0
 */
@Controller
@RequestMapping("/index")
public class HelloWorldController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "index";
    }
}
