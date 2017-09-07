package com.dilu.common.base.impl;

import com.dilu.common.base.BaseMapper;
import com.dilu.common.base.BaseService;
import com.dilu.common.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author guonima
 * @create 2017-09-06 11:23
 */
public class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseMapper<T, ID> baseMapper;

    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    @Transactional
    public int insert(T t) {
        if (null == t) {
            return 0;
        }
        try {
            return baseMapper.insert(t);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public int insertBatch(List<T> t) {
        if (null == t || t.isEmpty()) {
            return 0;
        }
        try {
            return baseMapper.insertBatch(t);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public int deleteBatchById(List<ID> ids) {
        if (null == ids || ids.isEmpty()) {
            return 0;
        }
        try {
            return baseMapper.deleteBatchById(ids);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public int deleteById(ID id) {
        if (null == id) {
            return 0;
        }
        try {
            return baseMapper.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public int deleteById(String id) {
        if (null == id) {
            return 0;
        }
        try {
            return baseMapper.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int update(T t) {
        if (null == t) {
            return 0;
        }
        try {
            return baseMapper.update(t);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public T find(Map<String, Object> parameter) {
        return null;
    }

    @Override
    public T find(T t) {
        return baseMapper.find(t);
    }

    @Override
    public T findById(ID id) {
        return baseMapper.findById(id);
    }

    @Override
    public T findById(String id) {
        return baseMapper.findById(id);
    }

    @Override
    public T findByName(String name) {
        return baseMapper.findByName(name);
    }

    @Override
    public List<T> queryListAll(Map<String, Object> parameter) {
        return baseMapper.queryListAll(parameter);
    }

    @Override
    public List<T> queryListAll(T t) {
        return baseMapper.queryListAll(t);
    }

    @Override
    public List<T> queryListByPage(Map<String, Object> parameter) {
        return baseMapper.queryListByPage(parameter);
    }

    @Override
    public int count(Map<String, Object> parameter) {
        return baseMapper.count(parameter);
    }

    @Override
    public int count(T t) {
        return baseMapper.count(t);
    }
}
