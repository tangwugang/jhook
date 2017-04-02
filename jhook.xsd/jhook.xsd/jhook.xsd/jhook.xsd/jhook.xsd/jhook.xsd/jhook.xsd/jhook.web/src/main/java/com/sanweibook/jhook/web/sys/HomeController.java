package com.sanweibook.jhook.web.sys;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by twg on 16/11/2.
 */
@Slf4j
@Controller
@RequestMapping("/admin/home")
public class HomeController {


    @RequestMapping
    @RequiresRoles("admin")
    public String home(Model model,HttpServletRequest request){
        if(log.isDebugEnabled()){
            log.debug(" uri : {}",request.getRequestURI());
        }
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("userName",subject.getPrincipals());
        return "home";
    }
}
