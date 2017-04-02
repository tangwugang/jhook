package com.sanweibook.jhook.shiro.realm;

/**
 * Created by twg on 16/11/7.
 */
public interface AuthcRealm {

    /**
     * 清除自定义AuthorizingRealm的认证信息
     */
    void clearCachedAuthenticationInfo(String key);

    /**
     * 清除自定义AuthorizingRealm的角色、权限信息
     */
    void clearCachedAuthorizationInfo(String key);
}
