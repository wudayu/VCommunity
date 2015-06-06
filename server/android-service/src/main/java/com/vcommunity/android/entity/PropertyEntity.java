package com.vcommunity.android.entity;

import com.google.common.collect.Lists;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

/**
 * 物业表
 *
 * @author James
 * @version 1.0
 * @date 4/27/15 9:44 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
@Entity
@Table(name = "t_property")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyEntity extends BaseEntity {

    /** 姓名 */
    @Column(name = "user_name")
    private String userName;

    /** 密码 */
    @Column(name = "password")
    private String password;

    @Transient
    private String plainPassword;

    /** 手机号 */
    @Column(name = "mobile")
    private String mobile;

    /** 员工编号 */
    @Column(name = "work_serial_no")
    private String workSerialNo;

    /** 员工的职称 */
    @Column(name = "level_name")
    private String levelName;

    /** 生日 */
    @Column(name = "birthday")
    private String birthday;

    /** level code */
    @Column(name = "level_code")
    private String levelCode;

    /** 性别 */
    @Column(name = "gender")
    private String gender;

    /** 身份证号 */
    @Column(name = "id_card")
    private String idCard;

    @OneToMany(mappedBy = "responsibility")
    private List<CompaintEntity> compaints = Lists.newArrayList();

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

    public List<CompaintEntity> getCompaints() {
        return compaints;
    }

    public void setCompaints(List<CompaintEntity> compaints) {
        this.compaints = compaints;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
