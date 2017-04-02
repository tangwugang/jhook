package com.sanweibook.jhook.generator.config;

import lombok.Data;

/**
 * Created by twg on 17/3/22.
 */
@Data
public class ColumnConfig {

    /**
     * 数据库列名
     */
    private String originalColumnName;
    /**
     * 数据库列名>>属性名
     */
    private String columnName;
    /**
     * 数据库列类型>>属性类型名
     */
    private String columnTypeName;

}
