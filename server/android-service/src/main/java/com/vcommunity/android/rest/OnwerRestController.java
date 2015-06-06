package com.vcommunity.android.rest;

import com.vcommunity.android.entity.OwnerEntity;
import com.vcommunity.android.service.OwnerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James Chow
 * @createdate 2015/5/11
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@RestController
@RequestMapping("/api/v/person")
public class OnwerRestController {

    @Autowired
    private OwnerEntityService service;

    @RequestMapping("/{id}")
    public OwnerEntity findOne(@PathVariable("id") String id) {
        return service.findOne(id);
    }
}
