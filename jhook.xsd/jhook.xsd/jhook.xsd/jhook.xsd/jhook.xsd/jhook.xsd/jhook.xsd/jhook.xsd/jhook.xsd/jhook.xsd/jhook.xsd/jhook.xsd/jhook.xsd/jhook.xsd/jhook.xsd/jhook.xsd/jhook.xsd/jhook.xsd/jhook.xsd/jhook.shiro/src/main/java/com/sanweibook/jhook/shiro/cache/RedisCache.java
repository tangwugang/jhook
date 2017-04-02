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
package com.sanweibook.jhook.shiro.cache;

import com.google.common.collect.Sets;
import com.sanweibook.jhook.redis.core.RedisClientTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.SerializationUtils;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Set;

/**
 * 存放用户认证、权限认证信息，故有两个不同的key @see com.sanweibook.lingdu.shiro.cache.RedisCache #getKeyByte
 * Created by twg on 16/11/6.
 */
@Slf4j
public class RedisCache<K, V> implements Cache<K, V> {

    private RedisClientTemplate redisClientTemplate;

    private String prefixKey;

    RedisCache(RedisClientTemplate redisClientTemplate) {
        if (redisClientTemplate == null) {
            throw new CacheException("RedisClientTemplate property cannot be null");
        }
        this.redisClientTemplate = redisClientTemplate;
    }

    RedisCache(RedisClientTemplate redisClientTemplate, String prefixKey) {
        this(redisClientTemplate);
        this.prefixKey = prefixKey;
    }

    private byte[] getKeyByte(K key) throws UnsupportedEncodingException {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (key instanceof String) {
            return (prefixKey + key).getBytes("UTF-8");
        }
        if (key instanceof PrincipalCollection) {
            log.info(" PrincipalCollection is " + ((PrincipalCollection) key).getPrimaryPrincipal().toString());
            return (prefixKey + "author_" + ((PrincipalCollection) key).getPrimaryPrincipal().toString()).getBytes("UTF-8");
        }
        log.info("The key is {}", key);
        return (prefixKey + "other_" + key).getBytes("UTF-8");
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        V value = null;
        try {
            value = (V) SerializationUtils.deserialize((byte[]) redisClientTemplate.get(getKeyByte(key)));
        } catch (UnsupportedEncodingException e) {
            log.error("The key: {} ,Get bytes is error", key, e);
            throw new CacheException(e);
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        try {
            redisClientTemplate.setEX(getKeyByte(key), SerializationUtils.serialize(value), redisClientTemplate.getExpiration());
        } catch (Exception e) {
            throw new CacheException(e);
        }
        return value;
    }

    @Override
    public V remove(K key) {
        try {
            redisClientTemplate.del(getKeyByte(key));
        } catch (Exception e) {
            throw new CacheException(e);
        }
        return get(key);
    }

    @Override
    public void clear() {
        log.info("This is redisCache clear()");
    }

    @Override
    public int size() {
        log.info("This is redisCache size()");
        return 0;
    }

    @Override
    public Set<K> keys() {
        Set<K> values = Sets.newHashSet();
        try {
            Set<byte[]> v = redisClientTemplate.hKeys(getKeyByte((K) (prefixKey + "*")));
            for (byte[] key : v) {
                values.add((K) key);
            }
        } catch (Exception e) {
            throw new CacheException(e);
        }
        return values;
    }

    @Override
    public Collection<V> values() {
        Set<V> values = Sets.newHashSet();
        try {
            Set<byte[]> v = redisClientTemplate.hKeys(getKeyByte((K) (prefixKey + "*")));
            for (byte[] key : v) {
                V value = (V) SerializationUtils.deserialize((byte[]) redisClientTemplate.get(key));
                values.add((V) value);
            }
        } catch (Exception e) {
            throw new CacheException(e);
        }
        return values;
    }
}
