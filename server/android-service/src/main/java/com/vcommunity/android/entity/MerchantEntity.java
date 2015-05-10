package com.vcommunity.android.entity;

import com.vcommunity.server.entity.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 商户用户表
 *
 * @author James
 * @version 1.0
 * @date 4/27/15 9:56 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
@Entity
@Table(name = "t_merchant")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MerchantEntity extends BaseEntity {

    /** 商户的名称 */
    @Column(name = "name")
    private String name;

    /** 登录系统的密码 */
    @Column(name = "password")
    private String password;

    /** 未经加密的原始密码，不会序列化到数据库当中 */
    @Transient
    private String plainPassword;

    /** 联系电话 */
    @Column(name = "contact_mobile")
    private String contactMobile;

    /** 商户的经理姓名 */
    @Column(name = "manager")
    private String manager;

    /** 管理者的联系电话 */
    @Column(name = "manager_mobile")
    private String managerMobile;

    /** 商户经营的方向类型 */
    @Column(name = "sell_type")
    private String sellType;

    /** 商户的性质，1. 民营 2. 国营 等 */
    @Column(name = "company_type")
    private String companyType;

    /** 经营的规模大小 */
    @Column(name = "scale_of_operation")
    private String scaleOfOperation;

    /** 营业执照的编号 */
    @Column(name = "sel_no")
    private String selNo;

    /** 法人代表 */
    @Column(name = "owner")
    private String owner;

    /** 地址 */
    @Column(name = "address")
    private String address;

    /** 经度 */
    @Column(name = "longitude")
    private String longitude;

    /** 纬度 */
    @Column(name = "latitude")
    private String latitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }

    public String getSellType() {
        return sellType;
    }

    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getScaleOfOperation() {
        return scaleOfOperation;
    }

    public void setScaleOfOperation(String scaleOfOperation) {
        this.scaleOfOperation = scaleOfOperation;
    }

    public String getSelNo() {
        return selNo;
    }

    public void setSelNo(String selNo) {
        this.selNo = selNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
