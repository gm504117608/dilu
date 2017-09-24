package com.dilu.service.photo;

import com.dilu.domain.photo.PhotoDetailDO;

import java.util.List;

/**
 * @author : guonima
 * @create : 2017-09-24-11:43
 */
public interface PhotoDetailService {

    public List<PhotoDetailDO> findByPhotoId(Long photoId);

}
