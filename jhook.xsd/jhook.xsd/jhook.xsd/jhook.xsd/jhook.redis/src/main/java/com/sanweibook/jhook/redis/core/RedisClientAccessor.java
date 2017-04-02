/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.sanweibook.jhook.redis.core;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sanweibook.jhook.redis.datasource.RedisDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;
import java.util.Set;

/**
 * Created by twg on 17/2/9.
 */
@Slf4j
public abstract class RedisClientAccessor<T> implements RedisClientOperations<T> {
    /**
     * redis 过期时间*
     */
    private volatile int expiration = 1800;

    private volatile RedisDataSource redisDataSource;

    public RedisClientAccessor(RedisDataSource redisDataSource) {
        this.redisDataSource = redisDataSource;
    }

    /**
     * 获取指定 key 的值
     *
     * @param key 键值
     * @return key不存在，返回null
     */
    @Override
    public T get(final T key) {
        Assert.notNull(key, "not null key required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return get(jedis, key);
        } catch (JedisException jedisException) {
            log.error("执行get方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 用于检查执行定 key 是否存在
     *
     * @param key 键值
     * @return
     */
    @Override
    public boolean exists(final T key) {
        Assert.notNull(key, "not null key required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return exists(jedis, key);
        } catch (JedisException jedisException) {
            log.error("执行exists方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 用于删除已存在的键。不存在的 key 会被忽略
     *
     * @param key 键值
     * @return 被删除 key 的数量
     */
    @Override
    public Long del(final T key) {
        Assert.notNull(key, "not null key required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return del(jedis, key);
        } catch (JedisException jedisException) {
            log.error("执行del方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 批量删除键值
     *
     * @param keys
     * @return
     */
    public Long delKeys(final T... keys) {
        Assert.notNull(keys, "not null key required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return delKeys(jedis, keys);
        } catch (JedisException jedisException) {
            log.error("执行delKeys方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 获取哈希表中的所有字段值
     *
     * @param key 键值
     * @return
     */
    @Override
    public Set<T> hKeys(final T key) {
        Assert.notNull(key, "not null key required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return hKeys(jedis, key);
        } catch (JedisException jedisException) {
            log.error("执行hKeys方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 哈希表所有字段的值
     *
     * @param key 键值
     * @return 字段值列表
     */
    @Override
    public List<T> hVals(final T key) {
        Assert.notNull(key, "not null key required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return hVals(jedis, key);
        } catch (JedisException jedisException) {
            log.error("执行hVals方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 用于设置 key 的过期时间。key 过期后将不再可用
     *
     * @param key    键值
     * @param second 秒
     * @return 0 失败 1 成功
     */
    @Override
    public Long expire(final T key, final int second) {
        Assert.notNull(key, "not null key required");
        Assert.notNull(second, "not null second required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return expire(jedis, key, second);
        } catch (JedisException jedisException) {
            log.error("执行expire方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 指定的 key 设置值及其过期时间
     *
     * @param key    键值
     * @param value  内容
     * @param second 过期时间，秒
     * @return OK 成功 null 失败
     */
    @Override
    public String setEX(final T key, final T value, final int second) {
        Assert.notNull(key, "not null key required");
        Assert.notNull(value, "not null value required");
        Assert.notNull(second, "not null second required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return setEX(jedis, key, value, second);
        } catch (JedisException jedisException) {
            log.error("执行setEX方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 设置指定 key 的值，并返回 key 旧的值，如果key 不存在，就添加
     *
     * @param key   键值
     * @param value 内容
     * @return 返回 key 旧的值，不存在返回null
     */
    @Override
    public T getSet(final T key, final T value) {
        Assert.notNull(key, "not null key required");
        Assert.notNull(value, "not null value required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return getSet(jedis, key, value);
        } catch (JedisException jedisException) {
            log.error("执行getSet方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 用于返回哈希表中，一个键，设定一个或多个执行定字段的值
     *
     * @param key   键值
     * @param field 字段
     * @param value 字段值
     * @return 1 成功 0 失败
     */
    @Override
    public Long hSet(final T key, final T field, final T value) {
        Assert.notNull(key, "not null key required");
        Assert.notNull(field, "not null field required");
        Assert.notNull(value, "not null value required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return hSet(jedis, key, field, value);
        } catch (JedisException jedisException) {
            log.error("执行hSet方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 用指定的字符串覆盖执行定 key 所储存的字符串值，覆盖的位置从偏移量 offset 开始
     *
     * @param key    键值
     * @param offset 偏移量开始值
     * @param value  内容
     * @return 被修改后的字符串长度
     */
    @Override
    public Long setRange(final T key, final Long offset, final T value) {
        Assert.notNull(key, "not null key required");
        Assert.notNull(value, "not null value required");
        Assert.notNull(offset, "not null offset required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return setRange(jedis, key, offset, value);
        } catch (JedisException jedisException) {
            log.error("执行setRange方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    @Override
    public String set(final T key, final T value) {
        return setEX(key, value, expiration);
    }

    /**
     * 用于将一个或多个值插入到列表的尾部(最右边)
     *
     * @param key    键值
     * @param values 内容
     * @return 列表的长度
     */
    @Override
    public Long rPush(final T key, final List<T> values) {
        Assert.notNull(key, "not null key required");
        Assert.notNull(values, "not null values required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return rPush(jedis, key, values);
        } catch (JedisException jedisException) {
            log.error("执行rPush方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 根据key值，获取列表中指定区间内的元素
     *
     * @param key 键值
     * @return 列表中指定区间内的元素
     */
    @Override
    public List<T> lRange(final T key) {
        Assert.notNull(key, "not null key required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return lRange(jedis, key);
        } catch (JedisException jedisException) {
            log.error("执行lRange方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    /**
     * 模糊获取键值
     *
     * @param pattern 模糊匹配sysuser:*
     * @return
     */
    @Override
    public Set<T> keys(final T pattern) {
        Assert.notNull(pattern, "not null pattern required");
        Jedis jedis = redisDataSource.getDataSource();
        boolean broken = false;
        try {
            return keys(jedis, pattern);
        } catch (JedisException jedisException) {
            log.error("执行keys方法时异常：", jedisException);
            broken = true;
            throw jedisException;
        } finally {
            redisDataSource.closeResource(jedis, broken);
        }
    }

    private T get(final Jedis jedis, final T key) {
        if (key instanceof String) {
            return (T) jedis.get((String) key);
        } else if (key instanceof byte[]) {
            return (T) jedis.get((byte[]) key);
        }
        return null;
    }

    private boolean exists(final Jedis jedis, final T key) {
        if (key instanceof String) {
            return jedis.exists((String) key);
        } else if (key instanceof byte[]) {
            return jedis.exists((byte[]) key);
        }
        return false;
    }

    private Long del(final Jedis jedis, final T key) {
        if (key instanceof String) {
            return jedis.del((String) key);
        } else if (key instanceof byte[]) {
            return jedis.del((byte[]) key);
        }
        return 0L;
    }

    private Long delKeys(final Jedis jedis, final T... keys) {
        Long v = 0L;
        if (keys instanceof String[][]) {
            v = jedis.del((String[]) keys);
        } else if (keys instanceof byte[][]) {
            v = jedis.del((byte[][]) keys);
        }
        return v;
    }

    private Set<T> hKeys(final Jedis jedis, final T key) {
        if (key instanceof String) {
            return (Set<T>) jedis.hkeys((String) key);
        } else if (key instanceof byte[]) {
            return (Set<T>) jedis.hkeys((byte[]) key);
        }
        return Sets.newHashSet();
    }

    private List<T> hVals(final Jedis jedis, final T key) {
        if (key instanceof String) {
            return (List<T>) jedis.hvals((String) key);
        } else if (key instanceof byte[]) {
            return (List<T>) jedis.hvals((byte[]) key);
        }
        return Lists.newArrayList();
    }

    private String setEX(final Jedis jedis, final T key, final T value, final int second) {
        if (key instanceof String) {
            return jedis.setex((String) key, second, (String) value);
        } else if (key instanceof byte[]) {
            return jedis.setex((byte[]) key, second, (byte[]) value);
        }
        return null;
    }

    private T getSet(final Jedis jedis, final T key, final T value) {
        T v = null;
        if (key instanceof String) {
            v = (T) jedis.getSet((String) key, (String) value);
        } else if (key instanceof byte[]) {
            v = (T) jedis.getSet((byte[]) key, (byte[]) value);
        }
        expire(key, expiration);
        return v;
    }

    private Long expire(final Jedis jedis, final T key, final int second) {
        if (key instanceof String) {
            return jedis.expire((String) key, second);
        } else if (key instanceof byte[]) {
            return jedis.expire((byte[]) key, second);
        }
        return 0L;
    }

    private Long hSet(final Jedis jedis, final T key, final T field, final T value) {
        Long v = 0L;
        if (key instanceof String) {
            v = jedis.hset((String) key, (String) field, (String) value);
        } else if (key instanceof byte[]) {
            v = jedis.hset((byte[]) key, (byte[]) field, (byte[]) value);
        }
        expire(key, expiration);
        return v;
    }

    private Long rPush(final Jedis jedis, final T key, final List<T> values) {
        Long v = 0L;
        if (key instanceof String) {
            v = jedis.rpush((String) key, values.toArray(new String[] { }));
        } else if (key instanceof byte[]) {
            v = jedis.rpush((byte[]) key, values.toArray(new byte[][] { }));
        }
        expire(key, expiration);
        return v;
    }

    private List<T> lRange(final Jedis jedis, final T key) {
        if (key instanceof String) {
            return (List<T>) jedis.lrange((String) key, 0, -1);
        } else if (key instanceof byte[]) {
            return (List<T>) jedis.lrange((byte[]) key, 0, -1);
        }
        return Lists.newArrayList();
    }


    private Long setRange(final Jedis jedis, final T key, final Long offset, final T value) {
        Long v = 0L;
        if (key instanceof String) {
            v = jedis.setrange((String) key, offset, (String) value);
        } else if (key instanceof byte[]) {
            v = jedis.setrange((byte[]) key, offset, (byte[]) value);
        }
        expire(key, expiration);
        return v;
    }

    private Set<T> keys(final Jedis jedis, final T pattern) {
        if (pattern instanceof String) {
            return (Set<T>) jedis.keys((String) pattern);
        } else if (pattern instanceof byte[]) {
            return (Set<T>) jedis.keys((byte[]) pattern);
        }
        return Sets.newHashSet();
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }
}
