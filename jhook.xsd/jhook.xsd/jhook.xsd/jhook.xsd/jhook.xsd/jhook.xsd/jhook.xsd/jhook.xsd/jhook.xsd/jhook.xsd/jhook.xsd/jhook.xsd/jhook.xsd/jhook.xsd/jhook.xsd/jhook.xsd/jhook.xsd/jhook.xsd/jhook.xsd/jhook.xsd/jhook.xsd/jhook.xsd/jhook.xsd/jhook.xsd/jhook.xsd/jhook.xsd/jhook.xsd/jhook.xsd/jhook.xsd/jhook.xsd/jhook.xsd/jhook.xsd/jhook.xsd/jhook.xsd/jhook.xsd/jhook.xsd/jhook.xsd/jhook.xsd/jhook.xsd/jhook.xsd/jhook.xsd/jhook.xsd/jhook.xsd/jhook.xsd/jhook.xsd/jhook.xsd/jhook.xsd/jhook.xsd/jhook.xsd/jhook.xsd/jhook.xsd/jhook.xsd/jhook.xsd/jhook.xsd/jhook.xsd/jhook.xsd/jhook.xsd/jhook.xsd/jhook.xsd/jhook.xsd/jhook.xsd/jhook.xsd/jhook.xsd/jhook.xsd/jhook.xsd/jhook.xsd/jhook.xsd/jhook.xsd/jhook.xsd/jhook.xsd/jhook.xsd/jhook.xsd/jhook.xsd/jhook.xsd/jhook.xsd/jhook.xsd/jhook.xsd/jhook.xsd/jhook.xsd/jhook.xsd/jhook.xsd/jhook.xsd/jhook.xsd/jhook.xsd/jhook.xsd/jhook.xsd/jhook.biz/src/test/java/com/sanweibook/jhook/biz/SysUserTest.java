package com.sanweibook.jhook.biz;

import com.google.common.collect.Lists;
import com.sanweibook.jhook.biz.sys.SysUserService;
import com.sanweibook.jhook.dal.model.sys.SysUser;
import com.sanweibook.jhook.dal.page.Page;
import com.sanweibook.jhook.dal.page.PageRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by twg on 17/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
public class SysUserTest {
    @Autowired
    SysUserService sysUserService;

    @Test
    public void testDelete(){
        SysUser sysUser = new SysUser();
        sysUserService.delete(sysUser);
    }

    @Test
    public void testDeleteById(){
        sysUserService.deleteById(293323600524476416L);
    }

    @Test
    public void testDeleteByIds(){
        List<Long> ids = Lists.newArrayList();
        ids.add(293071412497743872L);
        ids.add(293076656103358464L);
        sysUserService.deletedByIds(ids);
    }

    @Test
    public void testGet(){
        SysUser sysUser = new SysUser();
        sysUser.setUserName("twg");
        SysUser user = sysUserService.get(sysUser);
        Assert.assertNotNull("",user);
    }

    @Test
    public void testGetById(){
        SysUser sysUser = sysUserService.getById(293076656103358464L);
        Assert.assertNotNull(sysUser);
    }

    @Test
    public void testSave(){
        SysUser sysUser = new SysUser();
        sysUser.setUserName("34343434");
        sysUser.setPassword("11223344");
        sysUser.setCreator(1111111111L);
        sysUser.setModifier(sysUser.getCreator());
        sysUserService.save(sysUser);
        System.out.println("id :"+sysUser.getId());
    }

    @Test
    public void testUpdate(){
        SysUser sysUser = new SysUser();
        sysUser.setId(293071412497743872L);
        sysUser.setUserName("alibaba");
        sysUser.setIsDeleted(1);
//        sysUser.setPassword("112233");
        sysUserService.update(sysUser);
    }

    @Test
    public void testQueryByPage(){
        List<String> orders = Lists.newArrayList();
        orders.add("id desc");
        orders.add("user_name desc");
        SysUser sysUser = new SysUser();
//        sysUser.setIsDeleted(0);
        sysUser.setPage(new PageRequest<SysUser>(2,5,orders));
        Page page = sysUserService.queryByPages(sysUser);
        List<SysUser> sysUsers = page.getContents();
        System.out.println(sysUsers.size());
    }

    @Test
    public void testQueryAll(){
        SysUser sysUser = new SysUser();
        sysUser.setUserName("alibaba");
        List<SysUser> sysUsers = sysUserService.queryAll(sysUser);
        System.out.println(sysUsers.size());
    }

    @Test
    public void testQueryByIds(){
        List<Long> ids = Lists.newArrayList();
        ids.add(293071412497743872L);
        ids.add(293076656103358464L);
        List<SysUser> users = sysUserService.queryByIds(ids);
        Assert.assertTrue(users.size() == 2);
    }

    @Test
    public void testQueryCount(){
        SysUser sysUser = new SysUser();
        int r = sysUserService.queryCount(sysUser);
        Assert.assertTrue(r == 4);
    }

    @Test
    public void testBatchSave(){
        List<SysUser> sysUsers = Lists.newArrayList();
        for (int i = 0; i < 12; i++) {
            SysUser user = new SysUser();
            user.setUserName("333" + i);
            user.setPassword("777777");
            user.setCreator(1111111111L);
            user.setModifier(user.getCreator());
            sysUsers.add(user);
        }
        sysUserService.batchSave(sysUsers);
    }

    @Test
    public void testGenerator(){
        sysUserService.excecut();

    }




}
