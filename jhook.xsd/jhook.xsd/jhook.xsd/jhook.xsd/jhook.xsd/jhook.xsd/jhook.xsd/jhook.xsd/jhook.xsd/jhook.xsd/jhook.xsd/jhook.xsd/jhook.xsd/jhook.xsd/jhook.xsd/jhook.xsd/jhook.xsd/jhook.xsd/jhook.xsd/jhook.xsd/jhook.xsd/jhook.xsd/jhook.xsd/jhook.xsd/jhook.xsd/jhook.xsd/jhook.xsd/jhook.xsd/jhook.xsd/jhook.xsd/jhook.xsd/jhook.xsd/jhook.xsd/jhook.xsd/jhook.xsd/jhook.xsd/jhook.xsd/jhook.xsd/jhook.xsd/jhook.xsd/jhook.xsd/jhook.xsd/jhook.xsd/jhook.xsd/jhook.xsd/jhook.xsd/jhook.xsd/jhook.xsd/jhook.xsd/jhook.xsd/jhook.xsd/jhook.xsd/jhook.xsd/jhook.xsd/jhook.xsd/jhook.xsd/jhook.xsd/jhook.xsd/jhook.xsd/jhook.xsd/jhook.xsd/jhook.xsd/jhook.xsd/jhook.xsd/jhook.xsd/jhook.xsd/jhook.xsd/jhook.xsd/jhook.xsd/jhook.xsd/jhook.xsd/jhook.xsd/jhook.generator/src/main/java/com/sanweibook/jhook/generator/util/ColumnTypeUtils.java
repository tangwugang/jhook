package com.sanweibook.jhook.generator.util;

import com.sanweibook.jhook.common.exception.JhookException;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by twg on 17/3/22.
 */
public final class ColumnTypeUtils {
    private static volatile Map<String,String> columnTypeMap = new HashMap<String, String>();
    private ColumnTypeUtils(){}

    static {
        registerColumnType("BIT","Integer");
        registerColumnType("TINYINT","Integer");
        registerColumnType("SMALLINT","Integer");
        registerColumnType("INTEGER", "Integer");
        registerColumnType("BIGINT", "Long");
        registerColumnType("FLOAT", "Float");
        registerColumnType("DOUBLE", "Double");
        registerColumnType("NUMERIC", "Double");
        registerColumnType("DECIMAL", "BigDecimal");
        registerColumnType("CHAR", "String");
        registerColumnType("VARCHAR", "String");
        registerColumnType("LONGVARCHAR", "String");
        registerColumnType("DATE", "Date");
        registerColumnType("TIME", "Date");
        registerColumnType("TIMESTAMP", "Date");
    }


    public static String columnTypeName(String key){
        Assert.notNull(key,"The key must not be null");
        if (!columnTypeMap.containsKey(key)){
            throw new JhookException("The key get columntype error.");
        }
        return columnTypeMap.get(key);
    }





    private static void registerColumnType(String key,String value){
        columnTypeMap.put(key, value);
    }


}
