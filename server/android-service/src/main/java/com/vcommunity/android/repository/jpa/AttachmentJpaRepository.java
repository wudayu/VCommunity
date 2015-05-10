package com.vcommunity.android.repository.jpa;

import com.vcommunity.android.entity.Attachment;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public interface AttachmentJpaRepository extends PagingAndSortingRepository<Attachment, String>, JpaSpecificationExecutor<Attachment> {
}
