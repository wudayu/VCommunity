package com.vcommunity.server.entity;

import javax.persistence.Transient;

/**
 * @author James
 * @version 1.0
 * @date 4/27/15 9:44 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
public class PropertyEntity extends BaseEntity {

    /** 姓名 */
    private String userName;

    /** 密码 */
    private String password;

    @Transient
    private String plainPassword;

    /** 手机号 */
    private String mobile;

    /** 员工编号 */
    private String workSerialNo;

    /** 员工的职称 */
    private String levelName;

    /** 生日 */
    private String birthday;

    /** level code */
    private String levelCode;

    /** 性别 */
    private String gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getWorkSerialNo() {
        return workSerialNo;
    }

    public void setWorkSerialNo(String workSerialNo) {
        this.workSerialNo = workSerialNo;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
