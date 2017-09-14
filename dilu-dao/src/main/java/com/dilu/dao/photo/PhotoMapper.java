package com.dilu.dao.photo;

import com.dilu.common.base.BaseMapper;
import com.dilu.domain.photo.PhotoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : guonima
 * @create : 2017-09-14-21:51
 */
@Mapper
public interface PhotoMapper extends BaseMapper<PhotoDO, Long> {
}
