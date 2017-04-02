package com.sanweibook.jhook.shiro.realm;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sanweibook.jhook.shiro.util.ByteSourceUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by twg on 16/10/31.
 */
public class UserAuthorizingRealm extends AuthorizingRealm {

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Collection collection = principals.fromRealm(getName());
        if (collection.isEmpty()) {
            return null;
        }
        //登录时的用户名
        String userName = (String) collection.iterator().next();
        //todo 根据用户名去数据库查询
        System.out.println("========获取用户权限、角色信息========");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> userRoles = Sets.newHashSet();
        userRoles.add("admin");
        simpleAuthorizationInfo.setRoles(userRoles);
        List<String> rolePermissions = Lists.newArrayList();
        rolePermissions.add("sys:user:save");
        rolePermissions.add("sys:user:update");
        rolePermissions.add("sys:user:deleted");
        simpleAuthorizationInfo.addStringPermissions(rolePermissions);
        return simpleAuthorizationInfo;
    }

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        //todo 根据userName用户名去数据库查询 findByUserName，然后，数据库密码和输入的密码进行匹配校验
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        //d1e3ed816445bc26061ffeb02972a8db
        String oldPassword = "a3b9c70cf62760b6258610303a52428c";//963fcadca8c8c17cdab6f1927ced9904,  7f36f256c95fd64a5ca20078d1502e26
        //        String random = new SecureRandomNumberGenerator().nextBytes().toHex();
        String sha512Hash = new Md5Hash("123", userName + oldPassword, 2).toHex();
        System.out.println("密码 = " + sha512Hash);
        return new SimpleAuthenticationInfo(userName,"6109e73ac48ddca9078646c7d0861504", ByteSourceUtil.bytes(userName + oldPassword),getName());
    }
}
