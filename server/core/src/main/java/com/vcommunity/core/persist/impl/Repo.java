package com.vcommunity.core.persist.impl;

import com.vcommunity.core.persist.Params;

import java.sql.SQLException;

/**
 * @author James
 * @since V1.0
 */
public class Repo<T, ID> {

    public T save(T t) {
        return t;
    }

    public T update(T t) {
        return t;
    }

    public void save(String sqlName, Params params) throws SQLException {
    }
}
