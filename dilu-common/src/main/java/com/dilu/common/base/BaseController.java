package com.dilu.common.base;

import com.dilu.common.Response;
import com.dilu.common.domain.Pagination;
import com.dilu.common.exception.DataException;
import com.dilu.common.exception.ServiceException;
import com.dilu.common.exception.SystemException;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author guonima
 * @create 2017-09-06 11:20
 */
public class BaseController {

    /**
     * 错误返回 data默认null， message默认【操作失败】
     *
     * @return
     */
    public Response error(int code) {
        return error(code, "操作失败", null);
    }

    /**
     * 错误返回 data默认null
     *
     * @return
     */
    public Response error(int code, String message) {
        return error(code, message, null);
    }

    /**
     * 错误返回
     *
     * @return
     */
    public Response error(int code, String message, Object data) {
        Response resp = new Response(code, message, data);
        return resp;
    }

    /**
     * 正确返回，code默认0
     *
     * @return
     */
    public Response success(String message, Object data) {
        return success(0, message, data);
    }

    /**
     * 正确返回，code默认0, message默认【操作成功】
     *
     * @return
     */
    public Response success(Object data) {
        return success(0, "操作成功", data);
    }

    /**
     * 正确返回
     *
     * @return
     */
    public Response success(int code, String message, Object data) {
        Response resp = new Response(code, message, data);
        return resp;
    }

    /**
     * 系统异常统一处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public Response handlerException(Exception e) {
        Response resp = new Response(9999);
        if (e instanceof ServiceException) {
            resp.setMessage("肯定是你对不起我了");
        } else if (e instanceof SystemException) {
            resp.setMessage("哎哟！系统蹦了");
        } else if (e instanceof DataException) {
            resp.setMessage("数据离家出走了");
        } else {
            resp.setMessage("我想静静，不要问我静静是谁");
        }
        return resp;
    }

    /**
     * 处理数据分页信息
     *
     * @param pageInfo 分页信息
     */
    public Response handlerPagination(PageInfo pageInfo) {
        Pagination page = new Pagination();
        page.setPageNum(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotalNum(pageInfo.getPages());
        page.setTotalSize(pageInfo.getTotal());
        page.setList(pageInfo.getList());
        return success(page);
    }
}
