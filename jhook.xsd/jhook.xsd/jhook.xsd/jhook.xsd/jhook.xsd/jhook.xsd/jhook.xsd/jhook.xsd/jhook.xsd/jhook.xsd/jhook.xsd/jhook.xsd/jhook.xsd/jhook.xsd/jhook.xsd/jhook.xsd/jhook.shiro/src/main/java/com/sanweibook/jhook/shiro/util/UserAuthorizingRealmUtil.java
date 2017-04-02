package com.sanweibook.jhook.shiro.util;

import com.sanweibook.jhook.shiro.realm.AuthcRealm;
import com.sanweibook.jhook.shiro.realm.UserAuthorizingRealm;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by twg on 16/11/7.
 */
@Slf4j
public class UserAuthorizingRealmUtil implements AuthcRealm {

    private UserAuthorizingRealm realm;


    @Override
    public void clearCachedAuthenticationInfo(String key) {
        realm.getAuthenticationCache().remove(key);
        log.info("{}，清除用户认证信息成功", this.realm.getName());
    }

    @Override
    public void clearCachedAuthorizationInfo(String key) {
        realm.getAuthorizationCache().remove(key);
        log.info("{}，清除用户角色、权限信息成功", this.realm.getName());
    }

    public void setRealm(UserAuthorizingRealm realm) {
        this.realm = realm;
    }
}
