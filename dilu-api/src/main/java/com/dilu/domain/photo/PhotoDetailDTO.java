package com.dilu.domain.photo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : guonima
 * @create : 2017-09-24-11:59
 */
public class PhotoDetailDTO implements Serializable {

    private Long id;
    private Long photoId;
    private String picture;
    private Integer type;
    private String remark;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PhotoDetailDTO{" +
                "id=" + id +
                ", photoId=" + photoId +
                ", picture='" + picture + '\'' +
                ", remark='" + remark + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }

}
