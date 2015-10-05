package com.vcommunity.core.persist;

import java.util.HashMap;

/**
 * Database access param object.
 *
 * @author James
 * @since V1.0
 */
public final class Params extends HashMap<String, Object> {

    public static Params params() {
        Params params = new Params();

        return params;
    }

    public static Params params(final String key, final Object o) {
        Params params = new Params();
        params.put(key, o);

        return params;
    }
}
