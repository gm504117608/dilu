package com.dilu.service.photo.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.photo.PhotoDetailMapper;
import com.dilu.domain.photo.PhotoDetailDO;
import com.dilu.service.photo.PhotoDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : guonima
 * @create : 2017-09-24-11:43
 */
@Service("photoDetailService")
public class PhotoDetailServiceImpl extends AbstractService<PhotoDetailDO, Long> implements PhotoDetailService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhotoDetailMapper photoDetailMapper;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(photoDetailMapper);
    }

    @Override
    public List<PhotoDetailDO> findByPhotoId(Long photoId) {
        return photoDetailMapper.findByPhotoId(photoId);
    }


}
