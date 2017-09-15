package com.dilu.service.dictionary;

import com.dilu.domain.dictionary.DictionaryDO;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-15 16:53
 */
public interface DictionaryService {

    /**
     * 获取指定类型、代码值的字典信息
     *
     * @param type 字段类型
     * @param code 代码值
     * @return
     */
    public String getDictionaryName(String type, String code);

    /**
     * 获取指定类型、代码值的字典信息
     *
     * @param type 字段类型
     * @param code 代码值
     * @return
     */
    public DictionaryDO getDictionary(String type, String code);

    /**
     * 获取指定字段类型的字典信息
     *
     * @param type 字典类型
     * @return
     */
    public List<DictionaryDO> getDictionaries(String type);
}
