package com.vcommunity.server.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 小区表
 *
 * @author James
 * @version 1.0
 * @date 4/27/15 9:46 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
//@Entity
//@Table(name = "t_community")
public class CommunityEntity extends BaseEntity {

    /** 小区名 */
    private String name;

    /** 小区地址 */
    private String address;

    /** 是否是重点的开发小区项目 */
    private String isImportant;

    /** 经度 */
    private String longitude;

    /** 纬度 */
    private String latitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(String isImportant) {
        this.isImportant = isImportant;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
