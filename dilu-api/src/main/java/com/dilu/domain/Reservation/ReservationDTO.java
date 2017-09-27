package com.dilu.domain.Reservation;

import com.dilu.domain.consignee.ConsigneeAddressDTO;
import com.dilu.domain.coupon.CouponReceiveDTO;
import com.dilu.domain.photo.PhotoDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author guonima
 * @create 2017-09-27 11:11
 */
public class ReservationDTO implements Serializable {

    private Long id;
    private Long memberId;//会员id
    private String shoppingCarIds; //购物车唯一标识id串
    private Long consigneeId;//收货地址唯一标识id
    private Long couponReceiveId;//领取优惠券唯一标识id
    private String orderNo;//订单号
    private BigDecimal cost;//订单金额
    private BigDecimal expressCost;//快递金额
    private BigDecimal couponCost;//优惠券金额
    private BigDecimal reallyCost;//真实需要支付金额
    private String status;//订单状态
    private String statusName;//订单状态名称
    private String remark;//备注
    private Date createTime;
    private Date modifyTime;

    // 相册
    List<PhotoDTO> photos;
    // 优惠券
    private CouponReceiveDTO coupon;
    // 收货地址
    private ConsigneeAddressDTO consignee;


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

    public BigDecimal getExpressCost() {
        return expressCost;
    }

    public void setExpressCost(BigDecimal expressCost) {
        this.expressCost = expressCost;
    }

    public BigDecimal getCouponCost() {
        return couponCost;
    }

    public void setCouponCost(BigDecimal couponCost) {
        this.couponCost = couponCost;
    }

    public BigDecimal getReallyCost() {
        return reallyCost;
    }

    public void setReallyCost(BigDecimal reallyCost) {
        this.reallyCost = reallyCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public List<PhotoDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }

    public CouponReceiveDTO getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponReceiveDTO coupon) {
        this.coupon = coupon;
    }

    public ConsigneeAddressDTO getConsignee() {
        return consignee;
    }

    public void setConsignee(ConsigneeAddressDTO consignee) {
        this.consignee = consignee;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", shoppingCarIds='" + shoppingCarIds + '\'' +
                ", consigneeId=" + consigneeId +
                ", couponReceiveId=" + couponReceiveId +
                ", orderNo='" + orderNo + '\'' +
                ", cost=" + cost +
                ", expressCost=" + expressCost +
                ", couponCost=" + couponCost +
                ", reallyCost=" + reallyCost +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", photos=" + photos +
                ", coupon=" + coupon +
                ", consignee=" + consignee +
                '}';
    }
}
