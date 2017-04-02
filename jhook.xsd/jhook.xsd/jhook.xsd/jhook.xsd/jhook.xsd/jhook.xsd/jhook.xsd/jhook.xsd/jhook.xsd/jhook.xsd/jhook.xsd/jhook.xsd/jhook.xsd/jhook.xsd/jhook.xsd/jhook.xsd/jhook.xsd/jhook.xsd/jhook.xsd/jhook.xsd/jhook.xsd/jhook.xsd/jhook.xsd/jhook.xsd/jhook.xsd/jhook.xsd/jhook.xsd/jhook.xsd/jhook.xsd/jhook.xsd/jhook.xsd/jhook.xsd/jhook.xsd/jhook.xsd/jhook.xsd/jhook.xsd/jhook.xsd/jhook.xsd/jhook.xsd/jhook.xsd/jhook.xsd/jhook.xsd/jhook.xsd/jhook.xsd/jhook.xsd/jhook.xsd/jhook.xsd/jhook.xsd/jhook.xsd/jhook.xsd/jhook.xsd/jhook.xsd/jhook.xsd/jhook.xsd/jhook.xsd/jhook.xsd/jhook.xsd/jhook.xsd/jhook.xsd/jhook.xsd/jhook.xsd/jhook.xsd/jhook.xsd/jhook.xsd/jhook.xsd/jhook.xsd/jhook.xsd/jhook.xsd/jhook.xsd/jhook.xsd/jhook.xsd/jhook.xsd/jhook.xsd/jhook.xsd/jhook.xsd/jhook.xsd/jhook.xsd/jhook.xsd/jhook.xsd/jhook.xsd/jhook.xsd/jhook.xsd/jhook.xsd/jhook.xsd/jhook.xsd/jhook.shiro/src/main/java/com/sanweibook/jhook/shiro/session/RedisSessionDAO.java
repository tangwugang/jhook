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
package com.sanweibook.jhook.shiro.session;

import com.google.common.collect.Lists;
import com.sanweibook.jhook.common.exception.JhookException;
import com.sanweibook.jhook.redis.core.RedisClientTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by twg on 16/11/5.
 */
@Slf4j
public class RedisSessionDAO extends AbstractSessionDAO {

    private String prefixKey = "shiro_redis_session_";

    /*default session time out is 1800000 ms*/
    private int sessionTomeOut = 1800000;

    private RedisClientTemplate redisClientTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        session.setTimeout(sessionTomeOut);
        try {
            redisClientTemplate.setEX(getKeyByte(sessionId), SerializationUtils.serialize(session), sessionTomeOut/1000);
        } catch (UnsupportedEncodingException e) {
            log.error("Set Session's id:{} by byte is error. ",sessionId,e);
            throw new JhookException(e);
        }
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        try {
            byte[] bytes = (byte[]) redisClientTemplate.get(getKeyByte(sessionId));
            if(bytes == null){
                return null;
            }
            return (Session) SerializationUtils.deserialize(bytes);
        } catch (UnsupportedEncodingException e) {
            log.error("Get Session's id:{} by byte is error. ",sessionId,e);
            throw new JhookException(e);
        }
    }

    @Override
    public void update(Session session) {
        checkSession(session);
        session.setTimeout(sessionTomeOut);
        try {
            redisClientTemplate.setEX(getKeyByte(session.getId()), SerializationUtils.serialize(session), sessionTomeOut/1000);
        } catch (UnsupportedEncodingException e) {
            log.error("Update Session's id:{} by byte is error. ",session.getId(),e);
            throw new JhookException(e);
        }
    }

    @Override
    public void delete(Session session) {
        checkSession(session);
        if (log.isDebugEnabled()){
            log.debug("Delete Session's id:{} by byte.",session.getId());
        }
        try {
            redisClientTemplate.del(getKeyByte(session.getId()));
        } catch (UnsupportedEncodingException e) {
            log.error("Delete Session's id:{} by byte is error. ",session.getId(),e);
            throw new JhookException(e);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        List<Session> sessions = Lists.newArrayList();
        byte[] key = new byte[0];
        try {
            key = (this.prefixKey + "*").getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("GetActiveSessions is error. ",e);
            throw new JhookException(e);
        }
        Set<byte[]> v = redisClientTemplate.hKeys(key);
        for (byte[] k : v) {
            Session session = (Session) SerializationUtils.deserialize((byte[]) redisClientTemplate.get(k));
            sessions.add(session);
        }
        return sessions;
    }

    private byte[] getKeyByte(Serializable sessionId) throws UnsupportedEncodingException {
        String key = prefixKey + sessionId;
        return key.getBytes("UTF-8");
    }


    private void checkSession(Session session) {
        if (session == null || session.getId() == null) {
            throw new SessionException("Session cannot be null");
        }
    }

    public void setPrefixKey(String prefixKey) {
        this.prefixKey = prefixKey;
    }

    public void setSessionTomeOut(int sessionTomeOut) {
        this.sessionTomeOut = sessionTomeOut;
    }

    public void setRedisClientTemplate(RedisClientTemplate redisClientTemplate) {
        this.redisClientTemplate = redisClientTemplate;
    }
}
