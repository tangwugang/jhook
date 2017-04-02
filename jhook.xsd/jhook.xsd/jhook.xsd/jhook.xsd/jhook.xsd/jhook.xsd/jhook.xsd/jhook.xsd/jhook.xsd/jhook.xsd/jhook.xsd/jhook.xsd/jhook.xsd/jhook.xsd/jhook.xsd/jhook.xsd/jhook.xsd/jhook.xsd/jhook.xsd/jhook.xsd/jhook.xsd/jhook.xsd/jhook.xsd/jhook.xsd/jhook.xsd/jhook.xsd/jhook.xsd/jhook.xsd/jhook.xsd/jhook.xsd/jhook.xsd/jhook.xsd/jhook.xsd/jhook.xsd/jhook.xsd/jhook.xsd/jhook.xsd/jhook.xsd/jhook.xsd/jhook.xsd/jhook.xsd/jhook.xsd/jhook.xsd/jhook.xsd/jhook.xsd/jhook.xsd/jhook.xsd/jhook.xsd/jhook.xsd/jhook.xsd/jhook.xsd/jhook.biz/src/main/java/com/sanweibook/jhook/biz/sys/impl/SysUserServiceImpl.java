package com.sanweibook.jhook.biz.sys.impl;

import com.sanweibook.jhook.biz.CrudService;
import com.sanweibook.jhook.biz.sys.SysUserService;
import com.sanweibook.jhook.dal.dao.sys.SysUserDao;
import com.sanweibook.jhook.dal.model.sys.SysUser;
import com.sanweibook.jhook.dal.page.Page;
import com.sanweibook.jhook.generator.GeneratorProcessor;
import com.sanweibook.jhook.generator.param.GeneratorParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by twg on 17/3/16.
 */
@Service
public class SysUserServiceImpl extends CrudService<SysUserDao,SysUser> implements SysUserService {

    @Autowired
    private GeneratorProcessor generatorProcessor;

    @Override
    public void delete(SysUser sysUser) {
        delete(sysUser,"sysuser:*");
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id,"sysuser:*");
    }

    @Override
    public void deletedByIds(List<Long> ids) {
        deleteByIds(ids,"sysuser:*");
    }

    @Override
    public SysUser get(SysUser sysUser) {
        return get(sysUser,"sysuser:get");
    }

    @Override
    public SysUser getById(Long id) {
        return getById(id,"sysuser:getbyid");
    }

    @Override
    public void save(SysUser sysUser) {
        insert(sysUser,"sysuser:*");
    }

    @Override
    public void batchSave(List<SysUser> sysUsers) {
        batchInsert(sysUsers,"sysuser:*");
    }

    @Override
    public void update(SysUser sysUser) {
        update(sysUser,"sysuser:*");
    }

    @Override
    public int queryCount(SysUser sysUser) {
        return queryCount(sysUser,"sysuser:querycount");
    }

    @Override
    public List<SysUser> queryAll(SysUser sysUser) {
        return queryAll(sysUser,"sysuser:queryall");
    }

    @Override
    public List<SysUser> queryByIds(List<Long> ids) {
        return queryByIds(ids,"sysuser:querybyids");
    }

    @Override
    public Page<SysUser> queryByPages(SysUser sysUser) {
        return queryByPage(sysUser);
    }

    @Override
    public void excecut() {
        GeneratorParam generatorParam = new GeneratorParam();
        generatorParam.setTableName("sys_user");
        generatorParam.setModelName("sys");
        generatorParam.setPackageName("com.tqmall");
        generatorParam.setPathName("/Users/twg/");
        generatorParam.setType(4);
        generatorProcessor.excecut(generatorParam);
    }
}
