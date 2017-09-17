package com.dilu.controller.photo;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.service.dictionary.DictionaryService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : guonima
 * @create : 2017-09-14-21:29
 */
@RestController
@RequestMapping("/photos")
@Api(value = "PhotoController", description = "相册信息处理")
public class PhotoController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhotoService photoService;

    @Autowired
    private DictionaryService dictionaryService;


    @ApiOperation(value = "获取相册信息", notes = "通过分页信息、查询条件获取相册信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "searchValue", value = "查询条件", required = false, dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public Response findPhotos(@RequestParam String pageNum, @RequestParam String pageSize, @RequestParam String searchValue) {
        logger.info("获取相册信息，第几页：{}；每页数量{}，查询条件{}", pageNum, pageSize, searchValue);

        if (StringUtils.isEmpty(pageNum)) {
            pageNum = "1";
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = "10";
        }
        Map<String, Object> param = new HashMap<>();
        param.put("searchValue", searchValue);
        PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize), " create_time desc ");
        List<Map<String, Object>> list = photoService.queryListByPage(param);
        for (Map<String, Object> map : list) {
            map.put("typeName", dictionaryService.getDictionaryName("photo-style",
                    map.get("type") == null ? "" : (map.get("type")).toString()));
        }
        return handlerPagination(new PageInfo(list));
    }

    @ApiOperation(value = "获取指定相册信息", notes = "通过相册唯一标识获取相册信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "相册信息唯一标识", required = true, dataType = "String", paramType = "path"),
    })
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Response findPhotoById(@PathVariable String id) {
        logger.info("获取相册信息，相册唯一标示ID：{}", id);

        return success(photoService.findById(Long.valueOf(id)));
    }
}