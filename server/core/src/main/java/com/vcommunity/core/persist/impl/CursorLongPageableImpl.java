package com.vcommunity.core.persist.impl;

import com.vcommunity.core.persist.CursorPageable;

/**
 * Cursor pageable implement class.
 *
 * @author James
 * @since V1.0
 * @link CursorPageable
 */
public class CursorLongPageableImpl implements CursorPageable<Long> {
    private Long next;
    private Long prev;
    private int size;

    @Override
    public Long getNext() {
        return next;
    }

    @Override
    public Long getPrev() {
        return prev;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setNext(Long next) {
        this.next = next;
    }

    @Override
    public void setPrev(Long prev) {
        this.prev = prev;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
