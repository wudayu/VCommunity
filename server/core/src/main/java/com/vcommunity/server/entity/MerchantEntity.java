package com.vcommunity.server.entity;

import javax.persistence.Transient;

/**
 * @author James
 * @version 1.0
 * @date 4/27/15 9:56 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
public class MerchantEntity extends BaseEntity {

    private String name;

    private String password;

    @Transient
    private String plainPassword;

    private String contactMobile;

    private String manager;

    private String managerMobile;

    private String sellType;

    private String companyType;

    private String scaleOfOperation;

    private String selNo;

    private String owner;

    private String address;

    private String longitude;

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
