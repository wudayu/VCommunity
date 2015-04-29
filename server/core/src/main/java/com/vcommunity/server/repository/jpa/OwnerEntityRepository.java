package com.vcommunity.server.repository.jpa;

import com.vcommunity.server.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 业主JPA数据库操作接口
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public interface OwnerEntityRepository extends PagingAndSortingRepository<OwnerEntity, String>, JpaSpecificationExecutor<OwnerEntity> {
}
