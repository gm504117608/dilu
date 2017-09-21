package com.dilu.domain.coupon;

import com.dilu.common.base.BaseDO;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guonima
 * @create 2017-09-21 15:47
 */
@Alias("couponDO")
public class CouponDO extends BaseDO {

    private String name; // 系统发布优惠券名称
    private Long couponNo; // 系统发布优惠券编号
    private String type; // 系统发布优惠券类型
    private BigDecimal amount; // 优惠券金额
    private BigDecimal limitingCondition; // 优惠券限制使用条件
    private Integer validRange; // 领用之后的有效期间（单位：天）【用领用时间加上该值计算优惠券有效区间】
    private Integer enabled; // 是否可用【1（可用）；0（不可用）】
    private String remark; // 备注
    private Date createTime;
    private Long createUser;
    private Date modifyTime;
    private Long modifyUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(Long couponNo) {
        this.couponNo = couponNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getValidRange() {
        return validRange;
    }

    public void setValidRange(Integer validRange) {
        this.validRange = validRange;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public String toString() {
        return "CouponDO{" +
                "name='" + name + '\'' +
                ", couponNo=" + couponNo +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", limitingCondition=" + limitingCondition +
                ", validRange=" + validRange +
                ", enabled=" + enabled +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", modifyTime=" + modifyTime +
                ", modifyUser=" + modifyUser +
                '}';
    }
}
