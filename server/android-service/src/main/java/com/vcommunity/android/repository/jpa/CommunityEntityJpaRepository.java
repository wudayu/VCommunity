package com.vcommunity.android.repository.jpa;

import com.vcommunity.android.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 小区JPA数据库操作接口
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public interface CommunityEntityJpaRepository extends PagingAndSortingRepository<CommunityEntity, String>, JpaSpecificationExecutor<CommunityEntity> {
}
