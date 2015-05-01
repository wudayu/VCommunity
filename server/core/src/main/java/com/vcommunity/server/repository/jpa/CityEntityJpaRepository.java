package com.vcommunity.server.repository.jpa;

import com.vcommunity.server.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 城市JPA操作数据库接口
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public interface CityEntityJpaRepository extends PagingAndSortingRepository<CityEntity, String>, JpaSpecificationExecutor<CityEntity> {
}