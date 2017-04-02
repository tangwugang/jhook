package com.sanweibook.jhook.dal;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.sanweibook.jhook.dal.model.sys.SysRole;
import com.sanweibook.jhook.dal.model.sys.SysUser;
import com.sanweibook.jhook.dal.page.PageRequest;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twg on 17/3/16.
 */
public class SerieOb {
    public static void main(String[] args) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("twg");
        sysUser.setPassword("twg");
//        System.out.println(" sysUser: " + sysUser.toString());
        byte[] user = SerializationUtils.serialize(sysUser);

//        String u = ByteArrayUtil.toHexString(user);

//        System.out.println(" u: "+u);

        SysUser sysUsertwg = (SysUser) SerializationUtils.deserialize(user);

        for (int i = 0; i < 1; i++) {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("管理员");
            sysRole.setRoleAlias("admin");
            byte[] role = SerializationUtils.serialize(sysRole);
            StringBuilder sb = new StringBuilder(ByteArrayUtil.toHexString(role));
            sb.delete(0, sb.length() - 50);

//            System.out.println(""+sb.toString());
        }

        for (int i = 0; i < 1; i++) {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("管理员");
            byte[] role = SerializationUtils.serialize(sysRole);
            StringBuilder sb = new StringBuilder(ByteArrayUtil.toHexString(role));
            sb.delete(0, sb.length() - 50);

//            System.out.println(""+sb.toString());
        }

        for (int i = 0; i < 1; i++) {
            SysRole sysRole = new SysRole();
            byte[] role = SerializationUtils.serialize(sysRole);
            StringBuilder sb = new StringBuilder(ByteArrayUtil.toHexString(role));
            sb.delete(0, sb.length() - 50);

//            System.out.println(""+sb.toString());
        }

        List<String> ids = new ArrayList<String>();
        ids.add("001122");
        ids.add("001123");
        ids.add("001124");



        byte[] d = SerializationUtils.serialize(ids.toArray(new String[]{}));
//        System.out.println(""+ByteArrayUtil.toHexString(d));

        List<String> idss = new ArrayList<String>();
        idss.add("112233");
        idss.add("112244");
        idss.add("112255");



        byte[] ds = SerializationUtils.serialize(idss.toArray(new String[]{}));
//        System.out.println(""+ByteArrayUtil.toHexString(ds));






        SysUser sysUser1 = new SysUser();
        sysUser1.setId(1222322222l);

        sysUser1.setPage(new PageRequest(1,5,null));
        byte[] user11 = SerializationUtils.serialize(sysUser1);

        String u1 = ByteArrayUtil.toHexString(user11);
        System.out.println(" u1: "+u1);

        SysUser sysUser2 = new SysUser();
        sysUser2.setId(1222322222444555l);
        sysUser2.setPage(new PageRequest(2,5,null));
        byte[] user12 = SerializationUtils.serialize(sysUser2);

        String u2 = ByteArrayUtil.toHexString(user12);
        System.out.println(" u2: "+u2);

        /*SysUser sysUsertwg11 = (SysUser)SerializationUtils.deserialize(user11);


        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker();

        System.out.println(" ids : "+snowflakeIdWorker.nextId());
*/

    }
}
