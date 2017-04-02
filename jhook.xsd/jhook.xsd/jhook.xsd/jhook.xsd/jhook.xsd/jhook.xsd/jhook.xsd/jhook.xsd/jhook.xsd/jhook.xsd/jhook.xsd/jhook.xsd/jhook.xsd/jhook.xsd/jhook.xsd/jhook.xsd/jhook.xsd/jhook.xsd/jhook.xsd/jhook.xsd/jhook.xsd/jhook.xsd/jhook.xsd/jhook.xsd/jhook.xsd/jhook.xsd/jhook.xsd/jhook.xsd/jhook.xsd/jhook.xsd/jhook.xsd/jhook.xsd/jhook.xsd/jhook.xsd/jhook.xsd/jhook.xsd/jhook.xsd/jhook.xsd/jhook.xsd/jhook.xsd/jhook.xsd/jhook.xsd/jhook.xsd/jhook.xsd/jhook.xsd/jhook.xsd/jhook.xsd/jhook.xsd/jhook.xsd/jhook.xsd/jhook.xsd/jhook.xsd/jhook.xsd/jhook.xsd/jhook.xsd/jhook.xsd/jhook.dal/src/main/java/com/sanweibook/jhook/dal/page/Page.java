package com.sanweibook.jhook.dal.page;

import java.util.List;

/**
 * Created by twg on 17/3/9.
 */
public interface Page<T> {

    /**
     * 第几页
     * @return
     */
    int getPageNumber();

    /**
     * 每页要显示的数量
     * @return
     */
    int getPageSize();

    /**
     * SQL中的开始
     * @return
     */
    int getOffSet();

    /**
     * SQL中的结束
     * @return
     */
    int getLimit();

    /**
     * 总记录数
     * @return
     */
    int getCount();

    /**
     * 总页数
     * @return
     */
    int getPageTotal();

    /**
     * 记录集
     * @return
     */
    List<T> getContents();

    /**
     * SQL中的order by集
     * @return
     */
    List<String> orders();

}
