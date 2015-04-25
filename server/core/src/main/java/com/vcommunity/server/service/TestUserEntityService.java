package com.vcommunity.server.service;

import com.vcommunity.server.entity.TestUserEntity;
import com.vcommunity.server.repository.jpa.TestUserEntityJpaRepository;
import com.vcommunity.server.repository.mybatis.TestUserEntityMyBatisRepository;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Component
@Transactional
@Monitored
public class TestUserEntityService {

    private static Logger logger = LoggerFactory.getLogger(TestUserEntityService.class);

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

    public void save(TestUserEntity testUserEntity) {
        try {
            testUserEntityJpaRepository.save(testUserEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void saveByMyBatis(TestUserEntity testUserEntity) {
        try {
            testUserEntityMyBatisRepository.insertUser(testUserEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
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
