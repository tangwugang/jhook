package com.sanweibook.jhook.biz;

import com.sanweibook.jhook.common.util.JhookStringUtils;
import com.sanweibook.jhook.dal.dao.CrudDao;
import com.sanweibook.jhook.dal.model.BaseModel;
import com.sanweibook.jhook.dal.page.Page;
import com.sanweibook.jhook.dal.page.PageRequest;
import com.sanweibook.jhook.dal.util.SnowflakeIdWorker;
import com.sanweibook.jhook.redis.core.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.SerializationUtils;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by twg on 17/3/9.
 */
public abstract class CrudService<D extends CrudDao<T>, T extends BaseModel> extends BaseService {
    @Autowired
    private D crudDao;
    @Autowired
    private RedisClientTemplate redisClientTemplate;

    /**
     * 根据属性，删除记录
     *
     * @param t
     * @return
     */
    protected int delete(final T t, final String cacheKey) {
        Assert.notNull(t, "not null t required");
        removeCacheKeys(cacheKey);
        return crudDao.delete(t);
    }


    /**
     * 根据id，删除记录
     *
     * @param id
     * @return
     */
    protected int deleteById(final Long id, final String cacheKey) {
        Assert.notNull(id, "not null id required");
        removeCacheKeys(cacheKey);
        return crudDao.deleteById(id);
    }

    /**
     * 根据ids，批量删除记录
     *
     * @param ids
     * @return
     */
    protected int deleteByIds(final List<Long> ids, final String cacheKey) {
        Assert.notEmpty(ids, "ids must not empty");
        removeCacheKeys(cacheKey);
        return crudDao.deleteByIds(ids);
    }

    /**
     * 根据属性，获取单条记录
     *
     * @param t
     * @param cacheKey 缓存key(sysuer:get)
     * @return
     */
    protected T get(final T t, final String cacheKey) {
        Assert.notNull(t, "not null t required");
        if (JhookStringUtils.isBlank(cacheKey)) {
            return crudDao.get(t);
        }
        byte[] cachekey = super.createCachKey(t, cacheKey);
        byte[] v = (byte[]) redisClientTemplate.get(cachekey);
        if (null == v) {
            T r = crudDao.get(t);
            if (r != null) {
                redisClientTemplate.set(cachekey, SerializationUtils.serialize(r));
            }
            return r;
        }
        return (T) SerializationUtils.deserialize(v);
    }

    /**
     * 根据id，获取单条记录
     *
     * @param id
     * @param cacheKey 缓存key(sysuer:getbyid)
     * @return
     */
    protected T getById(final Long id, final String cacheKey) {
        Assert.notNull(id, "not null id required");
        if (JhookStringUtils.isBlank(cacheKey)) {
            return crudDao.getById(id);
        }
        byte[] cachekey = super.createCachKey(id, cacheKey);
        byte[] v = (byte[]) redisClientTemplate.get(cachekey);
        if (null == v) {
            T r = crudDao.getById(id);
            if (r != null) {
                redisClientTemplate.set(cachekey, SerializationUtils.serialize(r));
            }
            return r;
        }
        return (T) SerializationUtils.deserialize(v);
    }

    /**
     * 根据属性，获取记录集总数
     *
     * @param t
     * @param cacheKey 缓存key(sysuer:querycount)
     * @return
     */
    protected int queryCount(final T t, final String cacheKey) {
        Assert.notNull(t, "not null t required");
        if (JhookStringUtils.isBlank(cacheKey)) {
            return crudDao.queryCount(t);
        }
        byte[] cachekey = super.createCachKey(t, cacheKey);
        byte[] v = (byte[]) redisClientTemplate.get(cachekey);
        if (null == v) {
            int r = crudDao.queryCount(t);
            redisClientTemplate.set(cachekey, SerializationUtils.serialize(r));
            return r;
        }
        return (Integer) SerializationUtils.deserialize(v);
    }

    /**
     * 根据属性，获取全部记录集
     *
     * @param t
     * @param cacheKey 缓存key(sysuer:queryall)
     * @return
     */
    protected List<T> queryAll(final T t, final String cacheKey) {
        Assert.notNull(t, "not null t required");
        if (JhookStringUtils.isBlank(cacheKey)) {
            return crudDao.queryAll(t);
        }
        byte[] cachekey = super.createCachKey(t, cacheKey);
        byte[] v = (byte[]) redisClientTemplate.get(cachekey);
        if (null == v) {
            List<T> r = crudDao.queryAll(t);
            redisClientTemplate.set(cachekey, SerializationUtils.serialize(r));
            return r;
        }
        return (List<T>) SerializationUtils.deserialize(v);
    }

    /**
     * 根据ids，获取记录集（多条）
     *
     * @param ids
     * @param cacheKey 缓存key(sysuer:querybyids)
     * @return
     */
    protected List<T> queryByIds(final List<Long> ids, final String cacheKey) {
        Assert.notEmpty(ids, "ids must not empty");
        if (JhookStringUtils.isBlank(cacheKey)) {
            return crudDao.queryByIds(ids);
        }
        byte[] cachekey = super.createCachKey(ids, cacheKey);
        byte[] v = (byte[]) redisClientTemplate.get(cachekey);
        if (null == v) {
            List<T> r = crudDao.queryByIds(ids);
            redisClientTemplate.set(cachekey, SerializationUtils.serialize(r));
            return r;
        }
        return (List<T>) SerializationUtils.deserialize(v);
    }

    /**
     * 根据属性，分页获取记录集
     *
     * @param t
     * @return
     */
    protected Page<T> queryByPage(final T t) {
        Assert.notNull(t, "not null t required");
        PageRequest<T> pageRequest = (PageRequest<T>) t.getPage();
        pageRequest.setCount(crudDao.queryCount(t));
        pageRequest.setContents(crudDao.queryByPage(t));
        return pageRequest;
    }

    /**
     * 根据属性，添加记录
     *
     * @param t
     * @return
     */
    protected int insert(final T t, final String cacheKey) {
        Assert.notNull(t, "not null t required");
        removeCacheKeys(cacheKey);
        t.setId(SnowflakeIdWorker.getInstance().nextId());
        t.setIsDeleted(0);
        t.setGmtCreate(new Date());
        t.setGmtModified(t.getGmtCreate());
        return crudDao.insert(t);
    }

    /**
     * 根据属性，更新记录
     *
     * @param t
     * @return
     */
    protected int update(final T t, final String cacheKey) {
        Assert.notNull(t, "not null t required");
        removeCacheKeys(cacheKey);
        return crudDao.update(t);
    }

    /**
     * 根据ids，批量添加记录
     *
     * @param ts
     * @return
     */
    protected int batchInsert(final List<T> ts, final String cacheKey) {
        Assert.notEmpty(ts, "ts must not empty");
        removeCacheKeys(cacheKey);
        for (T t : ts) {
            t.setId(SnowflakeIdWorker.getInstance().nextId());
            t.setIsDeleted(0);
            t.setGmtCreate(new Date());
            t.setGmtModified(t.getGmtCreate());
        }
        int total = ts.size();
        int size = (int) Math.ceil((double) ts.size() / (double) BATCH_SIZE);
        for (int i = 0; i < size; i++) {
            if (i + 1 != size) {
                crudDao.batchInsert(ts.subList(i * BATCH_SIZE, i * BATCH_SIZE + BATCH_SIZE));
            } else {
                crudDao.batchInsert(ts.subList(i * BATCH_SIZE, total));
            }
        }
        return total;
    }


    private void removeCacheKeys(String cacheKey) {
        if (JhookStringUtils.isBlank(cacheKey)) {
            return;
        }
        Set<byte[]> b = redisClientTemplate.keys(JhookStringUtils.stringToByte(cacheKey));
        if (b.isEmpty()) {
            return;
        }
        redisClientTemplate.delKeys(b.toArray(new byte[][] { }));
    }
}
