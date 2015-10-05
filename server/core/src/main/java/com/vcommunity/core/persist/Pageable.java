package com.vcommunity.core.persist;

/**
 * Simple page interface.
 *
 * @author James
 * @since V1.0
 */
public interface Pageable {

    int getPage();

    int getOffset();

    int getSize();

    void setPage(int page);

    void setOffset(int offset);

    void setSize(int size);
}
