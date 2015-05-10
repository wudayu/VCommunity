package com.vcommunity.android.entity;

import com.google.common.collect.Lists;
import com.vcommunity.server.entity.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * 小区表
 *
 * @author James
 * @version 1.0
 * @date 4/27/15 9:46 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
@Entity
@Table(name = "t_community")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CommunityEntity extends BaseEntity {

    /** 小区名 */
    @Column(name = "name")
    private String name;

    /** 小区地址 */
    @Column(name = "address")
    private String address;

    /** 是否是重点的开发小区项目 */
    @Column(name = "is_important")
    private String isImportant;

    /** 经度 */
    @Column(name = "longitude")
    private String longitude;

    /** 纬度 */
    @Column(name = "latitude")
    private String latitude;

    @ManyToOne
    @JoinColumn(name = "city_uuid")
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "company_uuid")
    private PropertyCompanyEntity propertyCompany;

    @ManyToMany
    @JoinTable(name = "t_community_merchant", joinColumns = { @JoinColumn(name = "community_uuid") }, inverseJoinColumns = { @JoinColumn(name = "merchant_uuid") })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id ASC")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<MerchantEntity> merchants = Lists.newArrayList();

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

    public PropertyCompanyEntity getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(PropertyCompanyEntity propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public List<MerchantEntity> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<MerchantEntity> merchants) {
        this.merchants = merchants;
    }
}
