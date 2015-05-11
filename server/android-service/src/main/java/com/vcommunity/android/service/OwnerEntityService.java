package com.vcommunity.android.service;

import com.vcommunity.android.entity.OwnerEntity;
import com.vcommunity.android.repository.jpa.OwnerEntityJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 业主处理的service类
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Component
@Transactional(readOnly = true)
public class OwnerEntityService {
    @Autowired
    private OwnerEntityJpaRepository repository;

    public OwnerEntity findOne(String uuid) {
        return repository.findOne(uuid);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(OwnerEntity ownerEntity) {
        repository.save(ownerEntity);
    }
}
