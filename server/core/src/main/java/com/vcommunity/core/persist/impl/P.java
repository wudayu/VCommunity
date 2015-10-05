package com.vcommunity.core.persist.impl;

import com.vcommunity.core.persist.Pageable;

/**
 * @author James
 * @since V1.0
 */
public final class P {

    public static Pageable p(final int size, final int page) {
        Pageable pageable = new PageableImpl();
        pageable.setSize(size);
        pageable.setPage(page);

        return pageable;
    }

    public static Pageable po(final int offset, final int page) {
        Pageable pageable = new PageableImpl();
        pageable.setOffset(offset);
        pageable.setPage(page);

        return pageable;
    }
}
