package com.sanweibook.jhook.shiro.authc;

import com.sanweibook.jhook.shiro.hash.UserSimpleHash;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

/**
 * Created by twg on 16/11/2.
 */
public class UserCredentialsMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //todo 这里可以通过缓存，判断输入的用户和密码是否在暴力破解
        return super.doCredentialsMatch(token, info);
    }

    //生成密码
    public UserSimpleHash doPassword(AuthenticationToken token) {
        String random = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = new String((char[]) getCredentials(token));
        String username = (String) token.getPrincipal();
        UserSimpleHash simpleHash = new UserSimpleHash(this.getHashAlgorithmName(), password, username + random, this.getHashIterations());
        simpleHash.setRandomSalt(random);
        return simpleHash;
    }
}
