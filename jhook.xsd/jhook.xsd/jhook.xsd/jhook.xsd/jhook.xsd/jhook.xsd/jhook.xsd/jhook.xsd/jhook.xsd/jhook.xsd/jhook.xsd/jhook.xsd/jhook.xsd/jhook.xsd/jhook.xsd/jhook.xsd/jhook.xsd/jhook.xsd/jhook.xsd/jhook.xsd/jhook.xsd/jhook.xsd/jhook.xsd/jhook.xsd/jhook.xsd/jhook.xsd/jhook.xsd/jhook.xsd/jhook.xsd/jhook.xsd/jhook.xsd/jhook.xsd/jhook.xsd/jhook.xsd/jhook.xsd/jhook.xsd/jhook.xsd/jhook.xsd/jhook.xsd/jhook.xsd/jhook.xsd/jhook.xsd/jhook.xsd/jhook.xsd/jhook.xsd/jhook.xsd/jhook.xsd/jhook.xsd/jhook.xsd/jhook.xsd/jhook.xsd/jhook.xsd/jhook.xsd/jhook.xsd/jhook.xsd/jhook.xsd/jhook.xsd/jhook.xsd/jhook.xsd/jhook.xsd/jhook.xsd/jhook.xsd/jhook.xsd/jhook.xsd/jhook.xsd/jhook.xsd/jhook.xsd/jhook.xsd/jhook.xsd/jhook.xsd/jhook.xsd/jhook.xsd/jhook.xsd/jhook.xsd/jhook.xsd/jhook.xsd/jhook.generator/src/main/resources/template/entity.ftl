package ${packageName}.dal.model.${modelName};

import ${packageName}.dal.model.BaseModel;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
* Created by twg on 16/11/1.
*/
@Data
public class ${entityName?cap_first} extends BaseModel {
<#list columns as c>
private ${c.columnTypeName} ${c.columnName?uncap_first};
</#list>
}
