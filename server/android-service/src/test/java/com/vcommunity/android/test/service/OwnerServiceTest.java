package com.vcommunity.android.test.service;

import com.vcommunity.android.AndroidApplication;
import com.vcommunity.android.config.CoreApplication;
import com.vcommunity.android.entity.OwnerEntity;
import com.vcommunity.android.service.OwnerEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author James Chow
 * @createdate 2015/5/11
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CoreApplication.class })
public class OwnerServiceTest {

    @Autowired
    private OwnerEntityService ownerEntityService;

    @Test
    public void testSave() {
        OwnerEntity entity = new OwnerEntity();
        entity.setAddress("James Chow Home");
        entity.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        entity.setMobile("18551762946");
        entity.setCreateDate(new Date());
        entity.setModifyDate(new Date());

        ownerEntityService.save(entity);
    }
}
