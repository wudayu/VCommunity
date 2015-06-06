package com.vcommunity.android.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * JPA基础实体类
 *
 * @author James Chow
 * @createdate 2015/4/24
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String uuid;

    /** 这里的创建时间要精确到时分秒，为日期时间戳 */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    /** 修改时间也是一样的 */
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
