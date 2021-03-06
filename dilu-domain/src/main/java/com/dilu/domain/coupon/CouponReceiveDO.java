package com.dilu.domain.coupon;

import com.dilu.common.base.BaseDO;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guonima
 * @create 2017-09-21 15:39
 */
@Alias("couponReceiveDO")
public class CouponReceiveDO extends BaseDO {

    private Long memberId; // 会员id
    private Long couponId; // 系统发布优惠券id
    private BigDecimal amount; // 优惠券金额
    private BigDecimal limitingCondition; // 优惠券限制使用条件
    private Date startTime; // 有效开始日期
    private Date endTime; // 有效结束日期
    private Integer status; // 优惠券状态【0：可用，1：已使用，2：过期】
    private Date createTime;
    private Date modifyTime;

    // 以下字段保存不需要传入，目的为了查询使用
    private String name; //系统发布优惠券名称
    private String couponNo; //系统发布优惠券编号
    private String type; //系统发布优惠券类型

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getLimitingCondition() {
        return limitingCondition;
    }

    public void setLimitingCondition(BigDecimal limitingCondition) {
        this.limitingCondition = limitingCondition;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CouponReceiveDO{" +
                "memberId=" + memberId +
                ", couponId=" + couponId +
                ", amount=" + amount +
                ", limitingCondition=" + limitingCondition +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", name='" + name + '\'' +
                ", couponNo='" + couponNo + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
