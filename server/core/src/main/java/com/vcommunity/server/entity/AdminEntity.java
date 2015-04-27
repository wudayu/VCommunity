package com.vcommunity.server.entity;

/**
 * @author James
 * @version 1.0
 * @date 4/27/15 9:59 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
public class AdminEntity extends BaseEntity {

    private String loginName;

    private String password;

    private String plainPassword;

    private String userName;

    private String levelCode;

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
