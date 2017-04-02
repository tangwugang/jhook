package com.sanweibook.jhook.common.util;

import java.util.Objects;

/**
 * Created by twg on 17/3/15.
 */
public final class JhookObjectUtils extends org.apache.commons.lang3.ObjectUtils {

    /**
     * 对象转字符串
     * <p/>
     * Integer d = new Integer(2);
     * return 2
     *
     * @param object
     * @return
     */
    public static String objectToString(final Object object) {
        return object == null ? "" : Objects.toString(object);
    }

    /**
     * 对象转字符串
     *
     * @param object
     * @param nullString null时，返回nullString的值
     * @return
     */
    public static String objectToString(final Object object, String nullString) {
        return object == null ? nullString : Objects.toString(object);
    }


}
