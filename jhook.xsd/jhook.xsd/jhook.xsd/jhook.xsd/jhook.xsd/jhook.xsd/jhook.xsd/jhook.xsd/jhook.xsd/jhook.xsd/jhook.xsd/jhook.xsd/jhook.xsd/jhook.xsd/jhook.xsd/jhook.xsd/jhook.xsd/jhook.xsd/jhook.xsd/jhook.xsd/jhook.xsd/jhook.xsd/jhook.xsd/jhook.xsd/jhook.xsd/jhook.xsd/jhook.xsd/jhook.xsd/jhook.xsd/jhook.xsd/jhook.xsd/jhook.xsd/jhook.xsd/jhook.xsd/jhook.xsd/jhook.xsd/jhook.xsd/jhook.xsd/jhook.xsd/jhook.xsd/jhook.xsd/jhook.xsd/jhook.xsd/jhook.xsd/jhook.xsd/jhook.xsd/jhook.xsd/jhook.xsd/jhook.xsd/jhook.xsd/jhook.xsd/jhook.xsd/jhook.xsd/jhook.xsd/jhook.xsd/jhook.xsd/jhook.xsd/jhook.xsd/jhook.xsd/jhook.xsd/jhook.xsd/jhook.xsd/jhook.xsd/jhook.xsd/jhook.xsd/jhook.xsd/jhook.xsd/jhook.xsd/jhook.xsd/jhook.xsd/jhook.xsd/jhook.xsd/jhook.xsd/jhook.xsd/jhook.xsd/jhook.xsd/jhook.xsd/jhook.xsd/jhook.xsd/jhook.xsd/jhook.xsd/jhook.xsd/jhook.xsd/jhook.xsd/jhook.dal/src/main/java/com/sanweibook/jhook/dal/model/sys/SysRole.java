package com.sanweibook.jhook.dal.model.sys;

import com.sanweibook.jhook.dal.model.BaseModel;
import lombok.Data;

/**
 * Created by twg on 17/3/16.
 */
@Data
public class SysRole extends BaseModel {
    private String roleName;//角色名
    private String roleAlias;//角色别名
}
