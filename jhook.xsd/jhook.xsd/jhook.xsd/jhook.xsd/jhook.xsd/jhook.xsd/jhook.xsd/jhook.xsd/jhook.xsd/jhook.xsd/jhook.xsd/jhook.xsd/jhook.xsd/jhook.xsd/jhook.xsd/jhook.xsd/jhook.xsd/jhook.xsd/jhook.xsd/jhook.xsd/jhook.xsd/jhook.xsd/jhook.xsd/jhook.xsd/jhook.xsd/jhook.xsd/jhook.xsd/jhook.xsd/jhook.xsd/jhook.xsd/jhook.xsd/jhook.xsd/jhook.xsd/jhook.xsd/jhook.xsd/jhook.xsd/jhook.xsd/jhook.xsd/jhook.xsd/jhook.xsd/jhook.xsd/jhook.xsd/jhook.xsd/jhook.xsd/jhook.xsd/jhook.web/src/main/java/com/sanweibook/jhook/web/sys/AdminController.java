package com.sanweibook.jhook.web.sys;

import com.sanweibook.jhook.dal.model.sys.SysUser;
import com.sanweibook.jhook.shiro.authc.UserCredentialsMatcher;
import com.sanweibook.jhook.shiro.hash.UserSimpleHash;
import com.sanweibook.jhook.shiro.util.UserAuthorizingRealmUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by twg on 16/11/1.
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserCredentialsMatcher userCredentialsMatcher;
    @Autowired
    private UserAuthorizingRealmUtil userAuthorizingRealmUtil;


    /**
     * 用户登录首页
     *
     * @return
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String auth(SysUser user, Model model) {
        String userName = user.getUserName();
        String password = user.getPassword();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (IncorrectCredentialsException credentialException) {
            model.addAttribute("error", "用户名、密码错误");
            log.error("用户名、密码错误");
            return "login";
        } catch (UnknownAccountException unknownAccountException) {
            model.addAttribute("error", "用户名、密码错误");
            log.error("用户名、密码错误");
            return "login";
        }
        return "redirect:/admin/home.html";
    }

    @RequestMapping("chang-password")
    public String changPassword() {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("twg", "twg123456");
        UserSimpleHash simpleHash = userCredentialsMatcher.doPassword(usernamePasswordToken);
        //TODO 操作数据库，更新用户密码信息
        userAuthorizingRealmUtil.clearCachedAuthenticationInfo(usernamePasswordToken.getUsername());
        return "redirect:/admin/home.html";
    }
}
