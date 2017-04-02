package com.sanweibook.jhook.generator.processor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sanweibook.jhook.common.exception.JhookException;
import com.sanweibook.jhook.common.util.JhookStringUtils;
import com.sanweibook.jhook.generator.FileTypeEnum;
import com.sanweibook.jhook.generator.GeneratorProcessor;
import com.sanweibook.jhook.generator.config.ColumnConfig;
import com.sanweibook.jhook.generator.param.GeneratorParam;
import com.sanweibook.jhook.generator.util.ColumnTypeUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by twg on 17/3/23.
 */
@Slf4j
@Component
public class DefaultGeneratorProcessor implements GeneratorProcessor {
    @Autowired
    private DataSource dataSource;
    private static final String JAVA_SUFFIX = ".java";
    private static final String ERROR_SUFFIX = "generator error.";


    @Override
    public void excecut(GeneratorParam generatorParam) {
        Assert.hasLength(generatorParam.getTableName(), "tableName not null");
        Assert.hasLength(generatorParam.getPackageName(), "packageName not null");
        Assert.hasLength(generatorParam.getModelName(), "modelName not null");
        Assert.notNull(generatorParam.getType(), "type not null");
        List<ColumnConfig> columnConfigs = analyze(generatorParam.getTableName());
        Template template = loadingTemplate(generatorParam.getType());
        Map<String, Object> map = Maps.newHashMap();
        map.put("packageName", generatorParam.getPackageName());
        map.put("modelName", generatorParam.getModelName());
        map.put("tableName", generatorParam.getTableName());
        map.put("entityName", generatorParam.getEntityName());
        map.put("columns", columnConfigs);
        StringBuilder sb = new StringBuilder(generatorParam.getPathName());
        sb.append(File.separator);
        sb.append(generatorParam.getPackageName().replace(".","/"));
        sb.append(File.separator);
        File file = new File(sb.toString());
        if (!file.exists()){
            file.mkdirs();
        }
        sb.append(JhookStringUtils.attributeNameToUpperCase(generatorParam.getEntityName()));
        if (generatorParam.getType() == 3) {
            sb.append(".xml");
        } else if (generatorParam.getType() == 1) {
            sb.append("Service");
            sb.append(JAVA_SUFFIX);
        } else if (generatorParam.getType() == 2) {
            sb.append("Dao");
            sb.append(JAVA_SUFFIX);
        } else if (generatorParam.getType() == 4) {
            sb.append("ServiceImpl");
            sb.append(JAVA_SUFFIX);
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(sb.toString()));
            template.process(map, out);
        } catch (TemplateException e) {
            log.error(ERROR_SUFFIX,e);
            throw new JhookException(e);
        } catch (FileNotFoundException e) {
            log.error(ERROR_SUFFIX,e);
            throw new JhookException(e);
        } catch (IOException e) {
            log.error(ERROR_SUFFIX,e);
            throw new JhookException(e);
        } finally {
            close(out);
        }
    }

    private List<ColumnConfig> analyze(String tableName) {
        StringBuilder sb = new StringBuilder("select * from ");
        String sql = sb.append(tableName).toString();
        List<ColumnConfig> columnConfigs = Lists.newArrayList();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            ResultSetMetaData metaData = set.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                ColumnConfig columnConfig = new ColumnConfig();
                columnConfig.setOriginalColumnName(metaData.getColumnName(i));
                columnConfig.setColumnName(JhookStringUtils.attributeNameToPropertyName(metaData.getColumnName(i)));
                columnConfig.setColumnTypeName(ColumnTypeUtils.columnTypeName(JdbcType.forCode(metaData.getColumnType(i)).name()));
                columnConfigs.add(columnConfig);
            }
        } catch (SQLException e) {
            log.error("analyze sql error.", e);
            throw new JhookException(e);
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
            } catch (SQLException e) {
                log.error(ERROR_SUFFIX, e);
            }
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.error(ERROR_SUFFIX, e);
            }
        }
        return columnConfigs;
    }

    private Template loadingTemplate(int type) {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setClassForTemplateLoading(this.getClass(), "/template/");
        try {
            return configuration.getTemplate(FileTypeEnum.fileTypeName(type));
        } catch (IOException e) {
            log.error("load template error.", e);
            throw new JhookException(e);
        }
    }


    private void close(Writer o) {
        try {
            if (o != null) {
                o.flush();
            }
        } catch (IOException e) {
            log.error(ERROR_SUFFIX, e);
        }
        try {
            if (o != null) {
                o.close();
            }
        } catch (IOException e) {
            log.error(ERROR_SUFFIX,e);
        }
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
