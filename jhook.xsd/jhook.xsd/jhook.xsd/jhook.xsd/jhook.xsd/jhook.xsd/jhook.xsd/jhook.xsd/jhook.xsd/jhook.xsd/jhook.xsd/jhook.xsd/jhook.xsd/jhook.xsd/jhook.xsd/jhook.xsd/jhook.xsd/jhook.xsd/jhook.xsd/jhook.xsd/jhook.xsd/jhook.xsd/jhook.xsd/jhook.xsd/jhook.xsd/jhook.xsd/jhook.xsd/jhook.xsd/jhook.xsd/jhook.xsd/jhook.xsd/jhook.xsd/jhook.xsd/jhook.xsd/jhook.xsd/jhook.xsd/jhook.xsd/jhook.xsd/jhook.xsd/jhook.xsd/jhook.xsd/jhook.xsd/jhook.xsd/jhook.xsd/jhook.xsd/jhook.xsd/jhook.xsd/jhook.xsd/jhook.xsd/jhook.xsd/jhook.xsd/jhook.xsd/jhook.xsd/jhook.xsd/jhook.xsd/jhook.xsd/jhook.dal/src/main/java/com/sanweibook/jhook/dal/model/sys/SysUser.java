package com.sanweibook.jhook.dal.model.sys;

import com.sanweibook.jhook.dal.model.BaseModel;
import lombok.Data;

/**
 * Created by twg on 16/11/1.
 */
@Data
public class SysUser extends BaseModel {
    private String userName;
    private String password;
}
