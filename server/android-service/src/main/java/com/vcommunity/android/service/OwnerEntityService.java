package com.vcommunity.android.service;

import com.google.common.collect.Maps;
import com.vcommunity.android.entity.OwnerEntity;
import com.vcommunity.android.repository.jpa.OwnerEntityJpaRepository;
import com.vcommunity.server.modules.security.utils.Digests;
import com.vcommunity.server.modules.utils.Encodes;
import com.vcommunity.server.service.BusinessLogger;
import org.apache.commons.lang3.StringUtils;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * 业主处理的service类
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Transactional
@Monitored
@Component
public class OwnerEntityService {

    private OwnerEntityJpaRepository ownerEntityJpaRepository;

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    private static Logger logger = LoggerFactory.getLogger(OwnerEntityService.class);

    @Autowired
    private BusinessLogger businessLogger;

    /**
     * 保存用户
     *
     * @param entity
     */
    public void save(OwnerEntity entity) {
        if (StringUtils.isNotBlank(entity.getPlainPassword())) {
            entryptPassword(entity);
        }

        ownerEntityJpaRepository.save(entity);

        Map logData = Maps.newHashMap();
        logData.put("ownerId", entity.getUuid());
        businessLogger.log("OWNERENTITY", "UPDATE", "James", logData);
    }

    public OwnerEntity findOne(String uuid) {
        return ownerEntityJpaRepository.findOne(uuid);
    }

    /**
     * 将用户传入过来的plainPassword进行加盐算法处理后保存至数据库当中
     *
     * @param ownerEntity
     */
    private void entryptPassword(OwnerEntity ownerEntity) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        ownerEntity.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(ownerEntity.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
        ownerEntity.setPassword(Encodes.encodeHex(hashPassword));
    }


    public OwnerEntityJpaRepository getOwnerEntityJpaRepository() {
        return ownerEntityJpaRepository;
    }

    @Autowired
    public void setOwnerEntityJpaRepository(OwnerEntityJpaRepository ownerEntityJpaRepository) {
        this.ownerEntityJpaRepository = ownerEntityJpaRepository;
    }

    public static Logger getLogger() {
        return logger;
    }

    @Autowired
    public static void setLogger(Logger logger) {
        OwnerEntityService.logger = logger;
    }
}
