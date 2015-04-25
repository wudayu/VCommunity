package com.vcommunity.server.repository.mybatis;

import com.vcommunity.server.entity.TestUserEntity;
import com.vcommunity.server.modules.mybatis.repository.MyBatisRepository;

import java.util.List;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@MyBatisRepository
public interface TestUserEntityMyBatisRepository {
    List<TestUserEntity> findAll();

    TestUserEntity findOne(String uuid);
}
