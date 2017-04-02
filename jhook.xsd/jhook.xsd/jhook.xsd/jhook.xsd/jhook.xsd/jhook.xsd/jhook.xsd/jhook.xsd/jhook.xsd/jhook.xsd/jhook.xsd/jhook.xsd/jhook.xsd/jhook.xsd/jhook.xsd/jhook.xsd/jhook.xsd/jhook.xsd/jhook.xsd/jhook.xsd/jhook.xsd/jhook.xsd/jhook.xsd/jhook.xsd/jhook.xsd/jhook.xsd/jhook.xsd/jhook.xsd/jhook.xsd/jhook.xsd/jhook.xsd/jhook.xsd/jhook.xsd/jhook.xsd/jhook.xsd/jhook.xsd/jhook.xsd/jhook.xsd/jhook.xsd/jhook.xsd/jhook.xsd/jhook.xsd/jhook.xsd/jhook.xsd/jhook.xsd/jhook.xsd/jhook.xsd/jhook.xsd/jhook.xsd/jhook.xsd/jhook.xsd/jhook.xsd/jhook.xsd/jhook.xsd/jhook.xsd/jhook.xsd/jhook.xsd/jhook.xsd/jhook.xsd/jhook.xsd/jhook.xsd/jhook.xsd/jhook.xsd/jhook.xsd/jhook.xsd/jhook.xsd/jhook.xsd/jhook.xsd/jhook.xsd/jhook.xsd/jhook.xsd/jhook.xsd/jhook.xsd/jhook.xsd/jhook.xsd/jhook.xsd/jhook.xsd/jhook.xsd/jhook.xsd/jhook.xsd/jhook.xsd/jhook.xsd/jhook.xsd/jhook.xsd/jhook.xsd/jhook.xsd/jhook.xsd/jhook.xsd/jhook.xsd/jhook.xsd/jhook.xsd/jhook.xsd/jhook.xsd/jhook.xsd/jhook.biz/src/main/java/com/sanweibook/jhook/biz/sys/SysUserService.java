package com.sanweibook.jhook.biz.sys;

import com.sanweibook.jhook.dal.model.sys.SysUser;
import com.sanweibook.jhook.dal.page.Page;

import java.util.List;

/**
 * Created by twg on 17/3/16.
 */
public interface SysUserService {
    void delete(SysUser sysUser);

    void deleteById(Long id);

    void deletedByIds(List<Long> ids);

    SysUser get(SysUser sysUser);

    SysUser getById(Long id);

    void save(SysUser sysUser);

    void batchSave(List<SysUser> sysUsers);

    void update(SysUser sysUser);

    int queryCount(SysUser sysUser);

    List<SysUser> queryAll(SysUser sysUser);

    List<SysUser> queryByIds(List<Long> ids);

    Page<SysUser> queryByPages(SysUser sysUser);

    void excecut();
}
