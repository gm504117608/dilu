package com.dilu.service.photo;

import com.dilu.domain.photo.PhotoDO;

import java.util.List;
import java.util.Map;

/**
 * @author : guonima
 * @create : 2017-09-14-21:45
 */
public interface PhotoService {

    public PhotoDO findById(Long id);

    public List<PhotoDO> queryListAll(Map<String, Object> parameter);

    public List<Map<String, Object>> queryListByPage(Map<String, Object> parameter);

}
