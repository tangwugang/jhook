package com.sanweibook.jhook.web.sys;

import com.sanweibook.jhook.biz.sys.SysUserService;
import com.sanweibook.jhook.common.result.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by twg on 17/3/22.
 */
@Controller
@RequestMapping("/admin/generator")
public class GeneratorController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping
    @RequiresRoles("admin")
    public String index() {
        return "generator";
    }

    @RequestMapping("generat")
    @RequiresRoles("admin")
    @ResponseBody
    public Result<String> generatFile() {
        sysUserService.excecut();
        return Result.returnSuccessResult("");
    }


}
