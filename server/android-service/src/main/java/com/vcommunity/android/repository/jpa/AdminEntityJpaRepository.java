package com.vcommunity.android.repository.jpa;

import com.vcommunity.android.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 管理员JPA数据库操作类
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public interface AdminEntityJpaRepository extends PagingAndSortingRepository<AdminEntity, String>, JpaSpecificationExecutor<AdminEntity> {
}
