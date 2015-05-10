package com.vcommunity.android.entity;

import com.vcommunity.server.entity.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 管理员表
 *
 * @author James
 * @version 1.0
 * @date 4/27/15 9:59 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
@Entity
@Table(name = "t_admin")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AdminEntity extends BaseEntity {

    /** 登录名 */
    @Column(name = "login_name")
    private String loginName;

    /** 密码 */
    @Column(name = "password")
    private String password;

    /** 空白密码，不序列化到数据库的字段 */
    @Transient
    private String plainPassword;

    /** 用户的姓名 */
    @Column(name = "user_name")
    private String userName;

    /** 管理员的用户级别 */
    @Column(name = "level_code")
    private String levelCode;

    /** 管理员的类型，这里分为几个类型: 1. 商户管理员 2. 超级管理员 3. 物业管理员 */
    @Column(name = "type")
    private String type;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
