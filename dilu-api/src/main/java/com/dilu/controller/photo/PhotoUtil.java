package com.dilu.controller.photo;

import com.dilu.domain.photo.PhotoDO;
import com.dilu.domain.photo.PhotoDTO;
import com.dilu.domain.photo.PhotoDetailDO;
import com.dilu.domain.photo.PhotoDetailDTO;
import com.dilu.service.dictionary.DictionaryService;


/**
 * @author : guonima
 * @create : 2017-09-24-12:02
 */
public class PhotoUtil {

    public static PhotoDTO PhotoDO2PhotoDTO(PhotoDO photoDO, DictionaryService dictionaryService){
        if(photoDO == null){
            return null;
        }
        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setId(photoDO.getId());
        photoDTO.setName(photoDO.getName());
        photoDTO.setType(photoDO.getType());
        photoDTO.setTypeName(dictionaryService.getDictionaryName("photo-style", photoDO.getType() + ""));
        photoDTO.setSize(photoDO.getSize());
        photoDTO.setPrice(photoDO.getPrice());
        photoDTO.setProductionPrice(photoDO.getProductionPrice());
        photoDTO.setAgencyPrice(photoDO.getAgencyPrice());
        photoDTO.setPictureUrl(photoDO.getPictureUrl());
        photoDTO.setProductionUrl(photoDO.getProductionUrl());
        photoDTO.setRemark(photoDO.getRemark());
        photoDTO.setCreateTime(photoDO.getCreateTime());

        return photoDTO;
    }

    public static PhotoDetailDTO PhotoDetailDO2PhotoDetailDTO(PhotoDetailDO photoDetailDO){
        if(photoDetailDO == null){
            return null;
        }
        PhotoDetailDTO photoDetailDTO = new PhotoDetailDTO();

        photoDetailDTO.setId(photoDetailDO.getId());
        photoDetailDTO.setPhotoId(photoDetailDO.getPhotoId());
        photoDetailDTO.setPicture(photoDetailDO.getPicture());
        photoDetailDTO.setType(photoDetailDO.getType());
        photoDetailDTO.setRemark(photoDetailDO.getRemark());
        photoDetailDTO.setCreateTime(photoDetailDO.getCreateTime());

        return photoDetailDTO;
    }
}
