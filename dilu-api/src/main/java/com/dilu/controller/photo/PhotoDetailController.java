package com.dilu.controller.photo;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.domain.photo.PhotoDO;
import com.dilu.domain.photo.PhotoDTO;
import com.dilu.domain.photo.PhotoDetailDO;
import com.dilu.domain.photo.PhotoDetailDTO;
import com.dilu.service.dictionary.DictionaryService;
import com.dilu.service.photo.PhotoDetailService;
import com.dilu.service.photo.PhotoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : guonima
 * @create : 2017-09-24-11:51
 */
@RestController
@RequestMapping("/photos/detail")
@Api(value = "PhotoDetailController", description = "相册模板详情信息处理")
public class PhotoDetailController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoDetailService photoDetailService;

    @Autowired
    private DictionaryService dictionaryService;


    @ApiOperation(value = "获取相册模板详细信息", notes = "通过相册信息id获取相册模板详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "photoId", value = "相册模板id", required = true, dataType = "String", paramType = "path"),
    })
    @RequestMapping(value = "/{photoId}", method = {RequestMethod.GET})
    public Response findPhotosDetail(@PathVariable String photoId) {
        logger.info("获取相册模板详细信息，相册模板id：{}", photoId);

        if (StringUtils.isEmpty(photoId)) {
            return error(1000, "相册模板唯一标识不能为空");
        }
        PhotoDTO photoDTO = PhotoUtil.PhotoDO2PhotoDTO(photoService.findById(Long.valueOf(photoId)),
                dictionaryService);
        List<PhotoDetailDO> list = photoDetailService.findByPhotoId(Long.valueOf(photoId));
        List<PhotoDetailDTO> result = new ArrayList<>();
        for (PhotoDetailDO pd : list) {
            result.add(PhotoUtil.PhotoDetailDO2PhotoDetailDTO(pd));
        }
        photoDTO.setList(result);
        return success(photoDTO);
    }

}
