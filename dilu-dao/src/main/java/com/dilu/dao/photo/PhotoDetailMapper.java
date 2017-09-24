package com.dilu.dao.photo;


import com.dilu.common.base.BaseMapper;
import com.dilu.domain.photo.PhotoDetailDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : guonima
 * @create : 2017-09-24-11:30
 */
@Mapper
public interface PhotoDetailMapper extends BaseMapper<PhotoDetailDO, Long> {

    public List<PhotoDetailDO> findByPhotoId(Long photoId);
}
