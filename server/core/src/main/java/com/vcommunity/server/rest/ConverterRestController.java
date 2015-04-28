package com.vcommunity.server.rest;

import com.vcommunity.server.rest.dto.TestUserEntityDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author James Chow
 * @createdate 2015/4/28
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Controller
@RequestMapping("/api/user")
public class ConverterRestController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody TestUserEntityDTO findUser(@PathVariable("id") String id) {
        TestUserEntityDTO dto = new TestUserEntityDTO();
        dto.setCreateDate(new Date());
        dto.setModifyDate(new Date());
        dto.setAge(25);
        dto.setUserName("James Chow");
        dto.setUuid(id);

        return dto;
    }
}
