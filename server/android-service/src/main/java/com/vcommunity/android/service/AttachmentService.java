package com.vcommunity.android.service;

import com.vcommunity.android.entity.Attachment;
import com.vcommunity.android.repository.jpa.AttachmentJpaRepository;
import com.vcommunity.android.repository.mybatis.AttachmentMyBatisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Component
@Transactional(readOnly = true)
public class AttachmentService {

    private AttachmentJpaRepository attachmentJpaRepository;

    private AttachmentMyBatisRepository attachmentMyBatisRepository;

    private static Logger logger = LoggerFactory.getLogger(AttachmentService.class);

    @Transactional(readOnly = false)
    public void save(Attachment attachment) {
        try {
            attachmentMyBatisRepository.insert(attachment);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }


    public Attachment findOne(String id) {
        return attachmentJpaRepository.findOne(id);
    }

    public AttachmentJpaRepository getAttachmentJpaRepository() {
        return attachmentJpaRepository;
    }

    @Autowired
    public void setAttachmentJpaRepository(AttachmentJpaRepository attachmentJpaRepository) {
        this.attachmentJpaRepository = attachmentJpaRepository;
    }

    public AttachmentMyBatisRepository getAttachmentMyBatisRepository() {
        return attachmentMyBatisRepository;
    }

    @Autowired
    public void setAttachmentMyBatisRepository(AttachmentMyBatisRepository attachmentMyBatisRepository) {
        this.attachmentMyBatisRepository = attachmentMyBatisRepository;
    }
}
