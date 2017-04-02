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
package com.sanweibook.jhook.shiro.util;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

import java.io.File;
import java.io.InputStream;

/**
 * Created by twg on 16/11/7.
 */
public class ByteSourceUtil {
    /**
     * Returns a new {@code ByteSource} instance representing the specified byte array.
     *
     * @param bytes the bytes to represent as a {@code ByteSource} instance.
     * @return a new {@code ByteSource} instance representing the specified byte array.
     */
    public static ByteSource bytes(byte[] bytes) {
        return new MySimpleByteSource(bytes);
    }

    /**
     * Returns a new {@code ByteSource} instance representing the specified character array's bytes.  The byte
     * array is obtained assuming {@code UTF-8} encoding.
     *
     * @param chars the character array to represent as a {@code ByteSource} instance.
     * @return a new {@code ByteSource} instance representing the specified character array's bytes.
     */
    public static ByteSource bytes(char[] chars) {
        return new MySimpleByteSource(chars);
    }

    /**
     * Returns a new {@code ByteSource} instance representing the specified string's bytes.  The byte
     * array is obtained assuming {@code UTF-8} encoding.
     *
     * @param string the string to represent as a {@code ByteSource} instance.
     * @return a new {@code ByteSource} instance representing the specified string's bytes.
     */
    public static ByteSource bytes(String string) {
        return new MySimpleByteSource(string);
    }

    /**
     * Returns a new {@code ByteSource} instance representing the specified ByteSource.
     *
     * @param source the ByteSource to represent as a new {@code ByteSource} instance.
     * @return a new {@code ByteSource} instance representing the specified ByteSource.
     */
    public static ByteSource bytes(ByteSource source) {
        return new MySimpleByteSource(source);
    }

    /**
     * Returns a new {@code ByteSource} instance representing the specified File's bytes.
     *
     * @param file the file to represent as a {@code ByteSource} instance.
     * @return a new {@code ByteSource} instance representing the specified File's bytes.
     */
    public static ByteSource bytes(File file) {
        return new MySimpleByteSource(file);
    }

    /**
     * Returns a new {@code ByteSource} instance representing the specified InputStream's bytes.
     *
     * @param stream the InputStream to represent as a {@code ByteSource} instance.
     * @return a new {@code ByteSource} instance representing the specified InputStream's bytes.
     */
    public static ByteSource bytes(InputStream stream) {
        return new MySimpleByteSource(stream);
    }

    /**
     * Returns {@code true} if the specified object can be easily represented as a {@code ByteSource} using
     * the {@link ByteSource.Util}'s default heuristics, {@code false} otherwise.
     * <p/>
     * This implementation merely returns {@link SimpleByteSource}.{@link SimpleByteSource#isCompatible(Object) isCompatible(source)}.
     *
     * @param source the object to test to see if it can be easily converted to ByteSource instances using default
     *               heuristics.
     * @return {@code true} if the specified object can be easily represented as a {@code ByteSource} using
     *         the {@link ByteSource.Util}'s default heuristics, {@code false} otherwise.
     */
    public static boolean isCompatible(Object source) {
        return MySimpleByteSource.isCompatible(source);
    }

    /**
     * Returns a {@code ByteSource} instance representing the specified byte source argument.  If the argument
     * <em>cannot</em> be easily converted to bytes (as is indicated by the {@link #isCompatible(Object)} JavaDoc),
     * this method will throw an {@link IllegalArgumentException}.
     *
     * @param source the byte-backed instance that should be represented as a {@code ByteSource} instance.
     * @return a {@code ByteSource} instance representing the specified byte source argument.
     * @throws IllegalArgumentException if the argument <em>cannot</em> be easily converted to bytes
     *                                  (as indicated by the {@link #isCompatible(Object)} JavaDoc)
     */
    public static ByteSource bytes(Object source) throws IllegalArgumentException {
        if (source == null) {
            return null;
        }
        if (!isCompatible(source)) {
            String msg = "Unable to heuristically acquire bytes for object of type [" +
                    source.getClass().getName() + "].  If this type is indeed a byte-backed data type, you might " +
                    "want to write your own ByteSource implementation to extract its bytes explicitly.";
            throw new IllegalArgumentException(msg);
        }
        if (source instanceof byte[]) {
            return bytes((byte[]) source);
        } else if (source instanceof ByteSource) {
            return (ByteSource) source;
        } else if (source instanceof char[]) {
            return bytes((char[]) source);
        } else if (source instanceof String) {
            return bytes((String) source);
        } else if (source instanceof File) {
            return bytes((File) source);
        } else if (source instanceof InputStream) {
            return bytes((InputStream) source);
        } else {
            throw new IllegalStateException("Encountered unexpected byte source.  This is a bug - please notify " +
                    "the Shiro developer list asap (the isCompatible implementation does not reflect this " +
                    "method's implementation).");
        }
    }
}
