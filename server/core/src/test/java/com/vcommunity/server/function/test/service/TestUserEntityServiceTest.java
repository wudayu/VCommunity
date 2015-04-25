package com.vcommunity.server.function.test.service;

import static org.assertj.core.api.Assertions.*;

import com.vcommunity.server.entity.TestUserEntity;
import com.vcommunity.server.modules.test.spring.SpringTransactionalTestCase;
import com.vcommunity.server.service.TestUserEntityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@DirtiesContext
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
public class TestUserEntityServiceTest extends SpringTransactionalTestCase {
    private TestUserEntityService testUserEntityService;

    /**
     * Test Jpa service function.
     */
    @Test
    public void testUserEntityService() {
        TestUserEntity testUserEntity = new TestUserEntity();
        testUserEntity.setAge(25);
        testUserEntity.setUserName("James Chow");
        testUserEntity.setCreateDate(new Date());
        testUserEntity.setModifyDate(new Date());

        testUserEntityService.save(testUserEntity);

        // the userEntity object commit to the db, then have the uuid attribute
        assertThat(testUserEntity.getUuid()).isNotNull();
        String entityUuid = testUserEntity.getUuid();

        // test for Jpa find function.
        TestUserEntity findUserEntity = testUserEntityService.findUserByJpa(entityUuid);
        assertThat(findUserEntity.getUserName()).isEqualTo("James Chow");

        // test for Jpa findAll function.
        List<TestUserEntity> list = testUserEntityService.findAllByJpa();
        assertThat(list.size()).isEqualTo(1);

    }

    /**
     * Test TestUserEntityService MyBatis function.
     */
    @Test
    public void testUserMyBatisService() {
        TestUserEntity testUserEntity = new TestUserEntity();
        testUserEntity.setAge(25);
        testUserEntity.setUserName("James Chow");
        testUserEntity.setCreateDate(new Date());
        testUserEntity.setModifyDate(new Date());
        testUserEntity.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));

        testUserEntityService.saveByMyBatis(testUserEntity);

        TestUserEntity findUserEntity = testUserEntityService.findUserByMyBatis(testUserEntity.getUuid());
        assertThat(findUserEntity.getUserName()).isEqualTo("James Chow");

        List<TestUserEntity> list = testUserEntityService.findAllByMyBatis();
        assertThat(list.size()).isEqualTo(1);

    }

    public TestUserEntityService getTestUserEntityService() {
        return testUserEntityService;
    }

    @Autowired
    public void setTestUserEntityService(TestUserEntityService testUserEntityService) {
        this.testUserEntityService = testUserEntityService;
    }
}
