package com.vcommunity.core.persist;

/**
 * Cursor pageable interface.
 *
 * @author James
 * @since V1.0
 */
public interface CursorPageable<T> {
    T getNext();

    T getPrev();

    int getSize();

    void setNext(T next);

    void setPrev(T prev);

    void setSize(int size);
}
