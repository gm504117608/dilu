package com.dilu.common.base;

import java.io.Serializable;

/**
 * @author guonima
 * @create 2017-09-06 11:21
 */
public abstract class BaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

