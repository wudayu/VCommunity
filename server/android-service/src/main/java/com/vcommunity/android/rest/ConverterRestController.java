package com.vcommunity.android.rest;

import com.vcommunity.android.rest.vo.TestUserEntityDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author James Chow
 * @createdate 2015/4/28
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@RestController
@RequestMapping("/api/user")
public class ConverterRestController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TestUserEntityDTO findUser(@PathVariable("id") String id) {
        TestUserEntityDTO dto = new TestUserEntityDTO();
        dto.setCreateDate(new Date());
        dto.setModifyDate(new Date());
        dto.setAge(25);
        dto.setUserName("James Chow");
        dto.setUuid(id);

        return dto;
    }
}
