package com.dilu.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author guonima
 * @create 2017-09-06 11:23
 */
public interface BaseService<T, ID extends Serializable> {

    /**
     * @param t 插入的对象
     * @return int    返回影响的行数
     * @throws
     * @Title: insert
     * @Description: 插入对象
     */
    public int insert(T t);

    /**
     * @param t 插入的对象
     * @return int    返回影响的行数
     * @throws
     * @Title: insertBatch
     * @Description: 批量插入对象
     */
    public int insertBatch(List<T> t);

    /**
     * @param ids 删除的id
     * @return int    返回影响的行数
     * @throws
     * @Title: deleteBatchById
     * @Description: 批量删除
     */
    public int deleteBatchById(List<ID> ids);

    /**
     * @param id id
     * @return int    返回影响的行数
     * @throws
     * @Title: deleteById
     * @Description: 根据id删除
     */
    public int deleteById(ID id);

    /**
     * @param id id
     * @return int    返回影响的行数
     * @throws
     * @Title: deleteById
     * @Description: 根据id删除
     */
    public int deleteById(String id);

    /**
     * @param t 更新的对象
     * @return int    返回影响的行数
     * @throws
     * @Title: update
     * @Description: 更新对象
     */
    public int update(T t);

    /**
     * @param parameter 查询参数map
     * @return T    返回查询的对象
     * @throws
     * @Title: find
     * @Description: 根据参数查询对象
     */
    public T find(Map<String, Object> parameter);

    /**
     * @param t 查询参数对象
     * @return T    返回查询的对象
     * @throws
     * @Title: find
     * @Description: 根据参数查询对象
     */
    public T find(T t);

    /**
     * @param id id
     * @return T    返回查询的对象
     * @throws
     * @Title: findById
     * @Description: 根据id查询对象
     */
    public T findById(ID id);

    /**
     * @param id id
     * @return T    返回查询的对象
     * @throws
     * @Title: findById
     * @Description: 根据id查询对象
     */
    public T findById(String id);

    /**
     * @param name 名称
     * @return T    返回查询的对象
     * @throws
     * @Title: findByName
     * @Description: 根据名称查询
     */
    public T findByName(String name);

    /**
     * @param parameter 查询参数map
     * @return List<T>	返回查询的对象集合
     * @throws
     * @Title: queryListAll
     * @Description: 根据参数查询全部对象
     */
    public List<T> queryListAll(Map<String, Object> parameter);

    /**
     * @param t 查询参数对象
     * @return List<T>	返回查询的对象集合t
     * @throws
     * @Title: queryListAll
     * @Description: 根据参数查询全部对象
     */
    public List<T> queryListAll(T t);

    /**
     * @param parameter 查询参数map
     * @return List<T>	返回查询的对象集合
     * @throws
     * @Title: queryListAll
     * @Description: 根据分页参数查询对象
     */
    public List<T> queryListByPage(Map<String, Object> parameter);

    /**
     * @param parameter 查询参数map
     * @return int    返回查询的对象总条数
     * @throws
     * @Title: count
     * @Description: 根据参数查询对象总条数
     */
    int count(Map<String, Object> parameter);

    /**
     * @param t 查询参数对象
     * @return int    返回查询的对象总条数
     * @throws
     * @Title: count
     * @Description: 根据参数查询对象总条数
     */
    int count(T t);
}
