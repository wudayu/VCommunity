package com.vcommunity.server.repository.jpa;

import com.vcommunity.server.entity.TestUserEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gamil.com
 * @since v1.0
 */
public interface TestUserEntityJpaRepository extends PagingAndSortingRepository<TestUserEntity, String>, JpaSpecificationExecutor<TestUserEntity> {
}
