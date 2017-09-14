package com.dilu.service.photo.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.photo.PhotoMapper;
import com.dilu.domain.photo.PhotoDO;
import com.dilu.service.photo.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author : guonima
 * @create : 2017-09-14-21:46
 */
@Service("photoService")
public class PhotoServiceImpl extends AbstractService<PhotoDO, Long> implements PhotoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(photoMapper);
    }

}
