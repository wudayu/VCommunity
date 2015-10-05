package com.vcommunity.core.persist;

import java.io.Serializable;
import java.util.List;

/**
 * @author James
 * @since V1.0
 */
public class CursorPage<T extends Serializable, C extends Serializable> {

    private List<T> items;
    private C next;
    private C prev;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public C getNext() {
        return next;
    }

    public void setNext(C next) {
        this.next = next;
    }

    public C getPrev() {
        return prev;
    }

    public void setPrev(C prev) {
        this.prev = prev;
    }
}
