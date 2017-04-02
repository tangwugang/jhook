package com.sanweibook.jhook.biz;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.sanweibook.jhook.common.util.JhookStringUtils;
import org.springframework.util.SerializationUtils;

/**
 * Created by twg on 17/3/9.
 */
public abstract class BaseService {

    //批量插入条数
    protected static final int BATCH_SIZE = 1000;

    /**
     * 实体合成自定义缓存key，生成新的key
     * @param t 实体
     * @param cacheKey 自定义缓存key
     * @param <T>
     * @return
     */
    protected <T> byte[] createCachKey(T t, String cacheKey) {
        byte[] b = SerializationUtils.serialize(t);
        StringBuilder sb = new StringBuilder(ByteArrayUtil.toHexString(b));
        sb.delete(0, sb.length() - 50);
        return JhookStringUtils.stringToByte(String.format("%s:%s", cacheKey, sb.toString()));
    }

    /**
     * 字符串合成自定义缓存key，生成新的key
     * @param s
     * @param cacheKey 自定义缓存key
     * @return
     */
    protected byte[] createCachKey(Long s, String cacheKey) {
        return JhookStringUtils.stringToByte(String.format("%s:%d", cacheKey, s));
    }

}
