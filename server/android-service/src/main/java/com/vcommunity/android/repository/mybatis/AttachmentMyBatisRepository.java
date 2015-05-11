package com.vcommunity.android.repository.mybatis;

import com.vcommunity.android.entity.Attachment;
import com.vcommunity.android.persistence.MyBatisRepository;

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
