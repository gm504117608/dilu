package com.dilu.domain.reservation;

import com.dilu.common.base.BaseDO;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guonima
 * @create 2017-09-26 14:33
 */
@Alias("reservationDO")
public class ReservationDO extends BaseDO {

    private Long memberId;//会员id
    private String shoppingCarIds; //购物车唯一标识id串
    private Long consigneeId;//收货地址唯一标识id
    private Long couponReceiveId;//领取优惠券唯一标识id
    private String orderNo;//订单号
    private BigDecimal cost;//订单金额
    private String status;//订单状态
    private String remark;//备注
    private Date createTime;
    private Date modifyTime;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getShoppingCarIds() {
        return shoppingCarIds;
    }

    public void setShoppingCarIds(String shoppingCarIds) {
        this.shoppingCarIds = shoppingCarIds;
    }

    public Long getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Long consigneeId) {
        this.consigneeId = consigneeId;
    }

    public Long getCouponReceiveId() {
        return couponReceiveId;
    }

    public void setCouponReceiveId(Long couponReceiveId) {
        this.couponReceiveId = couponReceiveId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "ReservationDO{" +
                "memberId=" + memberId +
                ", shoppingCarIds='" + shoppingCarIds + '\'' +
                ", consigneeId=" + consigneeId +
                ", couponReceiveId=" + couponReceiveId +
                ", orderNo='" + orderNo + '\'' +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
