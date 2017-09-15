package com.dilu.dao.dictionary;

import com.dilu.common.base.BaseMapper;
import com.dilu.domain.dictionary.DictionaryDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guonima
 * @create 2017-09-15 16:46
 */
@Mapper
public interface DictionaryMapper extends BaseMapper<DictionaryDO, Long> {
}
