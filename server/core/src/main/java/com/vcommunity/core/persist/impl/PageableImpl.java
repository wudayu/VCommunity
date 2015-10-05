package com.vcommunity.core.persist.impl;

import com.vcommunity.core.persist.Pageable;

/**
 * Pageable implements class.
 *
 * @author James
 * @since V1.0
 * @link Pageable
 */
public class PageableImpl implements Pageable {
    private int page;
    private int offset;
    private int size;

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setPage(final int page) {
        this.page = page;
    }

    @Override
    public void setOffset(final int offset) {
        this.offset = offset;
    }

    @Override
    public void setSize(final int size) {
        this.size = size;
    }
}
