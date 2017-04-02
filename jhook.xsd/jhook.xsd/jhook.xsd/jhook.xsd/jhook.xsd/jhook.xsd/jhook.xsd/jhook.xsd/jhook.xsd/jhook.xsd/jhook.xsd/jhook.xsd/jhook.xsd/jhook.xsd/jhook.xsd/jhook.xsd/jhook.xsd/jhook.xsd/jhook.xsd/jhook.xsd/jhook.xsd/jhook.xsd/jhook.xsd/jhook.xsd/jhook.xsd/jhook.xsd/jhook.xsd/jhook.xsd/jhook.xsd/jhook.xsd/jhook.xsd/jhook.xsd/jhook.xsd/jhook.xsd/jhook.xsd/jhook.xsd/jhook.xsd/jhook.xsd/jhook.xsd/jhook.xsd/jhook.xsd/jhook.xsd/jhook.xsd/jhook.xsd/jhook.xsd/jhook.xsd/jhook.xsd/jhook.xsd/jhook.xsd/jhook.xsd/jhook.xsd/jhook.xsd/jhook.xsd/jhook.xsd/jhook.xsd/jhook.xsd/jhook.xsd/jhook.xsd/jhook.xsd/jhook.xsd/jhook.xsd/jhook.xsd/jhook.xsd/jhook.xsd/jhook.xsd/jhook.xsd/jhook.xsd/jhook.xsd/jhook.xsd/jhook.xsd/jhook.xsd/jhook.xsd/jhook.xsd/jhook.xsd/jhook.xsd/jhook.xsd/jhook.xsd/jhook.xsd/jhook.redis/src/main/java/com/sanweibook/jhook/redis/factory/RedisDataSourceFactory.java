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
package com.sanweibook.jhook.redis.factory;

import com.sanweibook.jhook.redis.datasource.RedisDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Created by twg on 16/11/3.
 */
@Slf4j
public class RedisDataSourceFactory implements RedisDataSource, InitializingBean {
    private int dbIndex = 0;
    private JedisPool jedisPool;
    private JedisShardInfo shardInfo;
    private JedisPoolConfig poolConfig = new JedisPoolConfig();


    @Override
    public Jedis getDataSource() {
        if (jedisPool != null) {
            return jedisPool.getResource();
        }
        Jedis jedis = new Jedis(getShardInfo());
        jedis.connect();
        if (dbIndex > 0) {
            jedis.select(dbIndex);
        }
        return jedis;
    }

    @Override
    public void closeResource(Jedis jedis, boolean broken) {
        try {
            if (jedisPool != null) {
                if (!broken) {
                    jedisPool.returnResource(jedis);
                    return;
                } else {
                    jedisPool.returnBrokenResource(jedis);
                    return;
                }
            }
            jedis.quit();
            jedis.disconnect();
        }catch (JedisDataException dataE){
            log.error("Jedis quit error.",dataE);
        }catch (JedisConnectionException connectE){
            log.error("Jedis disconnect error.",connectE);
        }catch (JedisException e){
            log.error("JedisPool returnResource error.",e);
        }
    }

    @Override
    public void destroy() {
        if (jedisPool != null) {
            jedisPool.destroy();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.jedisPool = new JedisPool(getPoolConfig(), getShardInfo().getHost(), getShardInfo().getPort(), getShardInfo().getConnectionTimeout(), getShardInfo().getPassword(), dbIndex);
    }

    public JedisShardInfo getShardInfo() {
        return shardInfo;
    }

    public void setShardInfo(JedisShardInfo shardInfo) {
        this.shardInfo = shardInfo;
    }

    public void setPoolConfig(JedisPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }

    public JedisPoolConfig getPoolConfig() {
        return poolConfig;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }
}
