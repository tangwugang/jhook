package ${packageName}.dal.dao.${modelName};


import ${packageName}.dal.annotation.MybatisDao;
import ${packageName}.dal.dao.CrudDao;
import ${packageName}.dal.model.${modelName}.${entityName?cap_first};

/**
* Created by twg on 17/3/10.
*/
@MybatisDao
public interface ${entityName?cap_first}Dao extends CrudDao<${entityName?cap_first}> {
}
