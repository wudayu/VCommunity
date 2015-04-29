package com.vcommunity.server.repository.jpa;

import com.vcommunity.server.entity.CompaintEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 投诉JPA数据库操作接口
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public interface CompaintEntityRepository extends PagingAndSortingRepository<CompaintEntity, String>, JpaSpecificationExecutor<CompaintEntity> {
}
