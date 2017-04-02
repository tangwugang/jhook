package com.sanweibook.jhook.generator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sanweibook.jhook.common.util.JhookStringUtils;
import com.sanweibook.jhook.generator.config.ColumnConfig;
import com.sanweibook.jhook.generator.param.GeneratorParam;
import com.sanweibook.jhook.generator.util.ColumnTypeUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.ibatis.type.JdbcType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by twg on 17/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-generator.test.xml")
public class GeneratorTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private GeneratorProcessor generatorProcessor;

    @Test
    public void t(){
        GeneratorParam generatorParam = new GeneratorParam();
        generatorParam.setTableName("sys_user");
        generatorParam.setModelName("sys");
        generatorParam.setPackageName("com.tqmall");
        generatorParam.setPathName("/Users/twg/");
        generatorParam.setType(4);
        generatorProcessor.excecut(generatorParam);
    }

    @Test
    public void fileGeneratorTest(){
        String pathName = "/Users/twg/workspace/jhook/jhook.biz/src/test/java/";
        String packageName = "com.tqmall.legend";
        String modelName = "sys";
        String tableName = "sys_user";
        String typeName = "";
        String entityName = JhookStringUtils.attributeNameToPropertyName(tableName);

        String sql = "select * from "+tableName;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            ResultSetMetaData metaData = set.getMetaData();
            List<ColumnConfig> columnConfigs = Lists.newArrayList();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                ColumnConfig columnConfig = new ColumnConfig();
                System.out.println(metaData.getColumnName(i));
                System.out.println(ColumnTypeUtils.columnTypeName(JdbcType.forCode(metaData.getColumnType(i)).name()));

                columnConfig.setOriginalColumnName(metaData.getColumnName(i));
                columnConfig.setColumnName(JhookStringUtils.attributeNameToPropertyName(metaData.getColumnName(i)));
                columnConfig.setColumnTypeName(ColumnTypeUtils.columnTypeName(JdbcType.forCode(metaData.getColumnType(i)).name()));

                columnConfigs.add(columnConfig);
            }

            Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            configuration.setClassForTemplateLoading(this.getClass(),"/");
            try {
                Template template = configuration.getTemplate(FileTypeEnum.fileTypeName(3));
                Map<String,Object> map = Maps.newHashMap();
                map.put("packageName",packageName);
                map.put("modelName",modelName);
                map.put("tableName",tableName);
                map.put("entityName",entityName);
                map.put("columns",columnConfigs);

                PrintWriter out  = new PrintWriter(new File("/Users/twg/workspace/jhook//"+entityName+".xml"));

                template.process(map,out);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e){

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
