package com.vcommunity.server.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 投诉表
 *
 * @author James
 * @version 1.0
 * @date 4/27/15 10:03 PM
 * @e-mail zhouxy.vortex@gmail.com
 */
//@Entity
//@Table(name = "t_compaint")
public class CompaintEntity extends BaseEntity {

    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

    /** 要投诉的地点 */
    private String address;

    /** 经度 */
    private String longitude;

    /** 纬度 */
    private String latitude;

    /** 投诉内容的当前状态 */
    private Integer status;

    /** 投诉内容处理的期限 */
    private Date deadline;

    /** 处理结果 */
    private String result;

    /** 业主对处理结果的评分 */
    private String rate;

    /** 对此次投诉处理的评论 */
    private String comment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
