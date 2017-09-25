package com.dilu.domain.reservation;

import com.dilu.common.base.BaseDO;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author guonima
 * @create 2017-09-25 16:15
 */
@Alias("shoppingCarDO")
public class ShoppingCarDO extends BaseDO {

    private Long memberId;
    private Long photoId;
    private Integer quantity;
    private Integer type;
    private Date createTime;
    private Date modifyTime;

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

    @Override
    public String toString() {
        return "ShoppingCarDO{" +
                "memberId=" + memberId +
                ", photoId=" + photoId +
                ", quantity=" + quantity +
                ", type=" + type +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
