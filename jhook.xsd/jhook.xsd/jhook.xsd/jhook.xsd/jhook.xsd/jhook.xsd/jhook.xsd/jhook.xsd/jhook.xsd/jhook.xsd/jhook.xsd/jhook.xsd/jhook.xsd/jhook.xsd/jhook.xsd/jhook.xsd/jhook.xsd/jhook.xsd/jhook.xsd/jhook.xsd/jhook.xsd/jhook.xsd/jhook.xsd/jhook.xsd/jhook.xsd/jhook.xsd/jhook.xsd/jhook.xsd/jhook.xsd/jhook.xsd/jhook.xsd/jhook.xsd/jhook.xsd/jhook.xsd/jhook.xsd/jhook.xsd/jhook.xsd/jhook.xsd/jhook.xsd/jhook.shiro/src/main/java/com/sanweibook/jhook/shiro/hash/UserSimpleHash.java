package com.sanweibook.jhook.shiro.hash;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 用户密码生成、盐值
 * Created by twg on 16/11/8.
 */
public class UserSimpleHash extends SimpleHash {

    private String randomSalt;

    public UserSimpleHash(String algorithmName) {
        super(algorithmName);
    }

    public UserSimpleHash(String algorithmName, Object source, Object salt, int hashIterations){
        super(algorithmName, source, salt, hashIterations);
    }

    public String getRandomSalt() {
        return randomSalt;
    }

    public void setRandomSalt(String randomSalt) {
        this.randomSalt = randomSalt;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
