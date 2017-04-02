package com.sanweibook.jhook.generator.param;

import com.sanweibook.jhook.common.util.JhookStringUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by twg on 17/3/23.
 */
@Data
public class GeneratorParam implements Serializable{
    private String pathName;//文件路径
    private String packageName;//包名
    private String modelName;//模块名
    private String tableName;//数据库表名
    private String entityName;//表名>>对应的实体名
    private Integer type;//需要生成的模板文件类型


    public String getEntityName(){
        if (StringUtils.isBlank(tableName)){
            return "";
        }
        return JhookStringUtils.attributeNameToPropertyName(tableName);
    }
}
