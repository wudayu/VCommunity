package com.vcommunity.core.persist.impl;

import com.vcommunity.core.persist.CursorPageable;
import com.vcommunity.core.persist.Pageable;

/**
 * @author James
 * @since V1.0
 */
public final class CP {
    public static CursorPageable<Long> cpNext(final Integer size, final Long next) {
        CursorPageable<Long> pageable = new CursorLongPageableImpl();
        pageable.setNext(next);
        pageable.setSize(size);

        return pageable;
    }
}
