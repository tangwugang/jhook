package com.sanweibook.jhook.dal;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * Created by twg on 17/3/17.
 */
public class DataSourceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext= new ClassPathXmlApplicationContext("spring-data.test.xml");
        DataSource dataSource = (DataSource) classPathXmlApplicationContext.getBean("dataSource");
        Assert.notNull(dataSource,"");
    }
}
