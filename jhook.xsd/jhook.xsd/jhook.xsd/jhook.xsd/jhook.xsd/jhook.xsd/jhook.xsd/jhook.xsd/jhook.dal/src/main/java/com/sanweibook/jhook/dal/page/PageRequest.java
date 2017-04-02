package com.sanweibook.jhook.dal.page;

import lombok.Data;

import java.util.List;

/**
 * Created by twg on 17/3/9.
 */
@Data
public class PageRequest<T> extends AbstractPageRequest<T> {

    /*记录集*/
    private List<T> contents;
    /*总记录数*/
    private int count;

    public PageRequest(int page, int size, List<String> orders) {
        super(page, size, orders);
    }
}
