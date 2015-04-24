package com.vcommunity.server.service;

import com.vcommunity.server.entity.TestUserEntity;
import com.vcommunity.server.repository.jpa.TestUserEntityJpaRepository;
import com.vcommunity.server.repository.mybatis.TestUserEntityMyBatisRepository;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gamil.com
 * @since v1.0
 */
@Component
@Transactional
@Monitored
public class TestUserEntityService {
    private TestUserEntityJpaRepository testUserEntityJpaRepository;

    private TestUserEntityMyBatisRepository testUserEntityMyBatisRepository;

    public List<TestUserEntity> findAllByJpa() {
        return (List<TestUserEntity>) testUserEntityJpaRepository.findAll();
    }

    public List<TestUserEntity> findAllByMyBatis() {
        return testUserEntityMyBatisRepository.findAll();
    }

    public TestUserEntity findUserByJpa(String uuid) {
        return testUserEntityJpaRepository.findOne(uuid);
    }

    public TestUserEntity findUserByMyBatis(String uuid) {
        return testUserEntityMyBatisRepository.findOne(uuid);
    }

    public TestUserEntityJpaRepository getTestUserEntityJpaRepository() {
        return testUserEntityJpaRepository;
    }

    @Autowired
    public void setTestUserEntityJpaRepository(TestUserEntityJpaRepository testUserEntityJpaRepository) {
        this.testUserEntityJpaRepository = testUserEntityJpaRepository;
    }

    public TestUserEntityMyBatisRepository getTestUserEntityMyBatisRepository() {
        return testUserEntityMyBatisRepository;
    }

    @Autowired
    public void setTestUserEntityMyBatisRepository(TestUserEntityMyBatisRepository testUserEntityMyBatisRepository) {
        this.testUserEntityMyBatisRepository = testUserEntityMyBatisRepository;
    }
}
