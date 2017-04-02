package com.sanweibook.jhook.dal.dao;


import com.sanweibook.jhook.dal.model.BaseModel;

import java.util.List;

/**
 * Created by twg on 17/3/9.
 */
public interface CrudDao<T extends BaseModel> extends BaseDao {

    /**
     * 根据属性，删除记录
     *
     * @param t
     * @return
     */
    int delete(final T t);

    /**
     * 根据id，删除记录
     *
     * @param id
     * @return
     */
    int deleteById(final Long id);

    /**
     * 根据ids，批量删除记录
     *
     * @param ids
     * @return
     */
    int deleteByIds(final List<Long> ids);

    /**
     * 根据属性，获取单条记录
     *
     * @param t
     * @return
     */
    T get(final T t);

    /**
     * 根据id，获取单条记录
     *
     * @param id
     * @return
     */
    T getById(final Long id);

    /**
     * 根据属性，获取记录集总数
     *
     * @param t
     * @return
     */
    int queryCount(final T t);

    /**
     * 根据属性，获取全部记录集
     *
     * @param t
     * @return
     */
    List<T> queryAll(final T t);

    /**
     * 根据ids，获取记录集（多条）
     *
     * @param ids
     * @return
     */
    List<T> queryByIds(final List<Long> ids);

    /**
     * 根据属性，分页获取记录集
     *
     * @param t
     * @return
     */
    List<T> queryByPage(final T t);

    /**
     * 根据属性，添加记录
     *
     * @param t
     * @return
     */
    int insert(final T t);

    /**
     * 根据属性，更新记录
     *
     * @param t
     * @return
     */
    int update(final T t);

    /**
     * 根据ids，批量添加记录
     *
     * @param ts
     * @return
     */
    int batchInsert(final List<T> ts);

}
