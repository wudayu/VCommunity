package com.vcommunity.server.entity;

import javax.persistence.Transient;

/**
 * @author James
 * @version 1.0
 * @date 4/27/15 9:36 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
public class OwnerEntity extends BaseEntity {
    /** 昵称 */
    private String nickname;

    /** 密码 */
    private String password;

    @Transient
    private String plainPassword;

    /** 手机号 */
    private String mobile;

    /** 生日 */
    private String birthday;

    /** 微信id */
    private String wechatId;

    /** 硬件的代码 */
    private String deviceCode;

    /** 所住的地址 */
    private String address;

    /** 性别 */
    private String gender;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
