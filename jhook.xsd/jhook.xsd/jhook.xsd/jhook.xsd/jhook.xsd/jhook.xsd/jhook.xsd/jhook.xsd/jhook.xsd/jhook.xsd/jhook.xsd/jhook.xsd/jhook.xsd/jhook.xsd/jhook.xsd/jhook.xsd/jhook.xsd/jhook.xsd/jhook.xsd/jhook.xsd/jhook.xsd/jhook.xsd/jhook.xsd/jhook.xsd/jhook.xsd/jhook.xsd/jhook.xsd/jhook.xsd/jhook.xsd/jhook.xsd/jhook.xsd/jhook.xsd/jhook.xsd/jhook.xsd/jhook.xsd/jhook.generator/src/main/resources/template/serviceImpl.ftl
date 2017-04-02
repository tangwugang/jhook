package ${packageName}.biz.${modelName}.impl;

import ${packageName}.biz.CrudService;
import ${packageName}.biz.${modelName}.${entityName?cap_first}Service;
import ${packageName}.dal.dao.${modelName}.${entityName?cap_first}Dao;
import ${packageName}.dal.model.${modelName}.${entityName?cap_first};
import ${packageName}.dal.page.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Created by twg on 17/3/16.
*/
@Service
public class ${entityName?cap_first}ServiceImpl extends CrudService<${entityName?cap_first}Dao,${entityName?cap_first}> implements ${entityName?cap_first}Service {

    @Override
    public void delete(${entityName?cap_first} ${entityName}) {
        delete(${entityName},"${entityName}:*");
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id,"${entityName}:*");
    }

    @Override
    public void deletedByIds(List<Long> ids) {
        deleteByIds(ids,"${entityName}:*");
    }

    @Override
    public ${entityName?cap_first} get(${entityName?cap_first} ${entityName}) {
        return get(${entityName},"${entityName}:get");
    }

    @Override
    public ${entityName?cap_first} getById(Long id) {
        return getById(id,"${entityName}:getbyid");
    }

    @Override
    public void save(${entityName?cap_first} ${entityName}) {
        insert(${entityName},"${entityName}:*");
    }

    @Override
    public void batchSave(List<${entityName?cap_first}> ${entityName}) {
        batchInsert(${entityName},"${entityName}:*");
    }

    @Override
    public void update(${entityName?cap_first} ${entityName}) {
        update(${entityName},"${entityName}:*");
    }

    @Override
    public int queryCount(${entityName?cap_first} ${entityName}) {
        return queryCount(${entityName},"${entityName}:querycount");
    }

    @Override
    public List<${entityName?cap_first}> queryAll(${entityName?cap_first} ${entityName}) {
        return queryAll(${entityName},"${entityName}:queryall");
    }

    @Override
    public List<${entityName?cap_first}> queryByIds(List<Long> ids) {
        return queryByIds(ids,"${entityName}:querybyids");
    }

    @Override
    public Page<${entityName?cap_first}> queryByPages(${entityName?cap_first} ${entityName}) {
        return queryByPage(${entityName});
    }
}
