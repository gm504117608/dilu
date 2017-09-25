package com.dilu.domain.Reservation;

import com.dilu.domain.photo.PhotoDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guonima
 * @create 2017-09-25 17:10
 */
public class ShoppingCarDTO implements Serializable {

    private Long id;
    private Long memberId;
    private Long photoId;
    private Integer quantity;
    private Integer type;
    private Date createTime;
    private Date modifyTime;

    private PhotoDTO photoDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public PhotoDTO getPhotoDTO() {
        return photoDTO;
    }

    public void setPhotoDTO(PhotoDTO photoDTO) {
        this.photoDTO = photoDTO;
    }

    @Override
    public String toString() {
        return "ShoppingCarDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", photoId=" + photoId +
                ", quantity=" + quantity +
                ", type=" + type +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", photoDTO=" + photoDTO +
                '}';
    }
}
