package com.sanweibook.jhook.dal.page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by twg on 17/3/9.
 */
public abstract class AbstractPageRequest<T> implements Serializable,Page<T> {

    private final int page;
    private final int size;
    private final List<String> orders;

    protected AbstractPageRequest(final int page, final int size, List<String> orders) {
        if (page < 0) {
            throw new PageException("page must not be less than zero");
        }
        if (size < 1 || size > 500) {//限制500，防止OOM
            throw new PageException("size must not be less than one or more than 500");
        }
        this.page = page < 1 ? 0 : page - 1;
        this.size = size < 1 ? 1 : size;
        this.orders = orders;
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public int getOffSet() {
        return page * size;
    }

    @Override
    public int getLimit() {
        return page < 1 ? 1 * size : size;
    }

    @Override
    public int getPageTotal() {
        return getPageSize() == 0 ? 1 : (int) Math.ceil((double) getCount() / (double) getPageSize());
    }

    @Override
    public List<String> orders() {
        return orders;
    }
}
