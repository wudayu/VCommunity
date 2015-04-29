package com.vcommunity.server.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 物业公司表
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Entity
@Table(name = "t_property_table")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyCompanyEntity extends BaseEntity {

    /** 公司名 */
    private String name;

    /** 公司的描述 */
    private String description;

    /** 联系方式 */
    private String contact;

    /** 公司的地址 */
    private String address;

    /** 公司管理员 */
    private String manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
