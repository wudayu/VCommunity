package com.wudayu.vcommunity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wudayu.vcommunity.constant.Constant;

/**
 * 
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Dec 8, 2014, 2:56:18 PM
 * @Description: VcUser是UserModel的Object Json对象
 * 
 **/

@JsonIgnoreProperties(ignoreUnknown=Constant.jsonIgnoreUnknown)
public class VcTestUser {

	private String uuid;
    private String userName;
    private int age;
    private String createDate;
    private String modifyDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "VcTestUser{" +
                "uuid='" + uuid + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                '}';
    }

}
/*
    "uuid" : "19506268550842b6b05bb5e3c0f618ce",
    "createDate" : "2015-04-23 16:00:00",
    "modifyDate" : "2015-04-23 16:00:00",
    "userName" : "James Chow",
    "age" : 20
*/