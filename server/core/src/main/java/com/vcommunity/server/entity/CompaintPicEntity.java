package com.vcommunity.server.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 投诉照片数据库
 *
 * @author James Chow
 * @createdate 2015/4/29
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Entity
@Table(name = "t_companit_pic")
public class CompaintPicEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "compaint_uuid")
    private CompaintEntity compaint;

    public CompaintEntity getCompaint() {
        return compaint;
    }

    public void setCompaint(CompaintEntity compaint) {
        this.compaint = compaint;
    }
}
