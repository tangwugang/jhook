package com.sanweibook.jhook.common.util;

import com.sanweibook.jhook.common.exception.JhookException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;

/**
 * Created by twg on 17/3/16.
 */
@Slf4j
public final class JhookStringUtils extends org.apache.commons.lang3.StringUtils {

    private static final String DEFAULT_ENCODE = "UTF-8";

    public static byte[] stringToByte(String s) {
        if (StringUtils.isBlank(s)) {
            return new byte[]{};
        }
        try {
            return s.getBytes(DEFAULT_ENCODE);
        } catch (UnsupportedEncodingException e) {
            log.error("String to byte[] is error.",e);
            throw new JhookException(e.getMessage());
        }
    }

    public static String attributeNameToUpperCase(String attributeName) {
        Assert.notNull(attributeName, "'attributeName' must not be null");
        char[] chars = attributeName.toCharArray();
        char[] result = new char[chars.length]; // not completely accurate but good guess
        int currPos = 0;
        boolean upperCaseNext = true;
        for (char c : chars) {
            if (upperCaseNext){
                result[currPos++] = Character.toUpperCase(c);
                upperCaseNext = false;
            }else {
                result[currPos++] = c;
            }
        }
        return new String(result, 0, currPos);
    }

    public static String attributeNameToPropertyName(String attributeName) {
        Assert.notNull(attributeName, "'attributeName' must not be null");
        if (!(attributeName.contains("_") || attributeName.contains("-"))) {
            return attributeName;
        }
        char[] chars = attributeName.toCharArray();
        char[] result = new char[chars.length -1]; // not completely accurate but good guess
        int currPos = 0;
        boolean upperCaseNext = false;
        for (char c : chars) {
            if (c == '_' || c == '-') {
                upperCaseNext = true;
            }
            else if (upperCaseNext) {
                result[currPos++] = Character.toUpperCase(c);
                upperCaseNext = false;
            }
            else {
                result[currPos++] = c;
            }
        }
        return new String(result, 0, currPos);
    }

}
