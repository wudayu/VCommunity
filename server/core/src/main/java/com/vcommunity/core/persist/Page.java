package com.vcommunity.core.persist;

import java.util.List;

/**
 * Page value.
 *
 * @author James
 * @since V1.0
 */
public class Page<T> {
    private List<T> items;
    private Long total;
    private Integer page;
    private Integer size;
    private Integer totalPage;

    public Page(List<T> items) {
        this.items = items;
    }

    public Page() {}

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
