package com.vcommunity.server.function.test.service;

import static org.assertj.core.api.Assertions.*;

import com.vcommunity.server.entity.OwnerEntity;
import com.vcommunity.server.modules.test.spring.SpringTransactionalTestCase;
import com.vcommunity.server.service.OwnerEntityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 业主Service测试类
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
public class OwnerEntityServiceTest extends SpringTransactionalTestCase {

    @Autowired
    private OwnerEntityService service;

    @Test
    public void testServiceSave() {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setNickname("James");
        ownerEntity.setPlainPassword("password");

        service.save(ownerEntity);
        // after save method invoke, the hibernate will create uuid for this entity
        assertThat(ownerEntity.getUuid()).isNotNull();

        String uuid = ownerEntity.getUuid();
        OwnerEntity findEntity = service.findOne(uuid);
        assertThat(findEntity.getSalt()).isNotNull();
        assertThat(findEntity.getPassword()).isNotNull();
//        assertThat(findEntity.getPlainPassword()).isNullOrEmpty();
        assertThat(findEntity).isEqualTo(ownerEntity);
    }
}
