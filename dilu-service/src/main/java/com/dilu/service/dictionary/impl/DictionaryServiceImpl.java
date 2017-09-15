package com.dilu.service.dictionary.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.common.cache.RedisClient;
import com.dilu.dao.dictionary.DictionaryMapper;
import com.dilu.domain.dictionary.DictionaryDO;
import com.dilu.service.dictionary.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-15 16:43
 */
@Service("dictionaryService")
public class DictionaryServiceImpl extends AbstractService<DictionaryDO, Long> implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(dictionaryMapper);
    }

    public String getDictionaryName(String type, String code) {
        DictionaryDO dictionaryDO = getDictionary(type, code);
        if (dictionaryDO == null) {
            return null;
        }
        return dictionaryDO.getName();
    }

    public DictionaryDO getDictionary(String type, String code) {
        List<DictionaryDO> list = getDictionaries(type);
        for (DictionaryDO dd : list) {
            if (dd.getCode().equals(code)) {
                return dd;
            }
        }
        return null;
    }

    public List<DictionaryDO> getDictionaries(String type) {
        List dictionary = redisClient.get("dictionary_" + type, List.class);
        if (null == dictionary) {
            DictionaryDO dictionaryDO = new DictionaryDO();
            dictionaryDO.setType(type);
            List<DictionaryDO> list = dictionaryMapper.queryListAll(dictionaryDO);
            redisClient.set("dictionary_" + type, 12 * 60 * 60, list);
            return list;
        }
        return dictionary;
    }
}
