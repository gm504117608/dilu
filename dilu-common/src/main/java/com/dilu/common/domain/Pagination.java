package com.dilu.common.domain;

import java.io.Serializable;

/**
 * 分页信息
 *
 * @author guonima
 * @create 2017-09-15 15:59
 */
public class Pagination implements Serializable {

    private int pageNum; // 第几页
    private int pageSize; // 每页显示数量
    private int totalNum; // 总共多少页
    private long totalSize; // 总共多少条
    private Object list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalNum=" + totalNum +
                ", totalSize=" + totalSize +
                ", list=" + list +
                '}';
    }
}
