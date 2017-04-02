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

import java.util.List;
import java.util.Set;

/**
 * Created by twg on 17/2/9.
 */
public interface RedisClientOperations<T> {

    T get(T key);

    Long del(T key);

    Long delKeys(T... keys);

    Set<T> hKeys(T key);

    List<T> hVals(T key);

    List<T> lRange(T key);

    boolean exists(T key);

    T getSet(T key, T value);

    Long expire(T key, int second);

    Long rPush(T key, List<T> values);

    Long hSet(T key, T field, T value);

    String set(T key,T value);

    String setEX(T key, T value, int second);

    Long setRange(T key, Long offset, T value);

    Set<T> keys(T pattern);



}
