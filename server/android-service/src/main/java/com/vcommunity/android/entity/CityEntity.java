package com.vcommunity.android.entity;

import com.vcommunity.server.entity.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 城市表
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Entity
@Table(name = "t_city")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CityEntity extends BaseEntity {

    @Column(name = "city_name")
    private String cityName;

    /** 地图展现的时候，显示的中心经度 */
    @Column(name = "longitude")
    private String longitude;

    /** 此城市展现的中心纬度 */
    @Column(name = "latitude")
    private String latitude;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
