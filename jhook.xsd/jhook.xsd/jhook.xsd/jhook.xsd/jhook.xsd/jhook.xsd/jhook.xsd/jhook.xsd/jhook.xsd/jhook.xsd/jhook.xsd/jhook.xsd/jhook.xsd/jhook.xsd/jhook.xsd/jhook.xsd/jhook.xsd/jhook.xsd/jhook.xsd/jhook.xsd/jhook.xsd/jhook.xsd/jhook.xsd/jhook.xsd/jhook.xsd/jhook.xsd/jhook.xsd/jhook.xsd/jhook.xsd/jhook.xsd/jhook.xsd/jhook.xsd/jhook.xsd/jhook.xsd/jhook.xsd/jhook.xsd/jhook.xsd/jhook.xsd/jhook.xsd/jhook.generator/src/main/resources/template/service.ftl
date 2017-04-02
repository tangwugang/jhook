package ${packageName}.biz.${modelName};

import ${packageName}.dal.model.${modelName}.${entityName?cap_first};
import ${packageName}.dal.page.Page;

import java.util.List;

/**
* Created by twg on 17/3/16.
*/
public interface ${entityName?cap_first}Service {

    void delete(${entityName?cap_first} ${entityName});

    void deleteById(Long id);

    void deletedByIds(List<Long> ids);

    ${entityName?cap_first} get(${entityName?cap_first} ${entityName});

    ${entityName?cap_first} getById(Long id);

    void save(${entityName?cap_first} ${entityName});

    void batchSave(List<${entityName?cap_first}> ${entityName});

    void update(${entityName?cap_first} ${entityName});

    int queryCount(${entityName?cap_first} ${entityName});

    List<${entityName?cap_first}> queryAll(${entityName?cap_first} ${entityName});

    List<${entityName?cap_first}> queryByIds(List<Long> ids);

    Page<${entityName?cap_first}> queryByPages(${entityName?cap_first} ${entityName});
}