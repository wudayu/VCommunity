package com.vcommunity.server.repository.mybatis;

import com.vcommunity.server.entity.Attachment;
import com.vcommunity.server.modules.mybatis.repository.MyBatisRepository;

/**
 * @author James Chow
 * @createdate 2015/4/25
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@MyBatisRepository
public interface AttachmentMyBatisRepository {

    void insert(Attachment attachment);
}
