package com.sanweibook.jhook.dal.model;

import com.sanweibook.jhook.dal.page.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by twg on 16/11/1.
 */
@Data
public abstract class BaseModel implements Serializable{
    protected Long id;//主键
    protected Long creator;//创建人
    protected Long modifier;//修改人
    protected Integer isDeleted;//是否删除0否1是
    protected Date gmtCreate;//创建时间
    protected Date gmtModified;//修改时间

    protected PageRequest page;

    public Integer getIsDeleted(){
        if (null == isDeleted){
            return 0;
        }
        return isDeleted;
    }
}
