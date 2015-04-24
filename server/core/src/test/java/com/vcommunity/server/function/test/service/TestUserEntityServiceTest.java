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

import java.util.List;

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

    @Test
    public void testUserEntityService() {
        List<TestUserEntity> list = testUserEntityService.findAllByJpa();
        assertThat(list.size()).isEqualTo(1);
        list = testUserEntityService.findAllByMyBatis();
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
