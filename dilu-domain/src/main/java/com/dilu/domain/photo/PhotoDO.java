package com.dilu.domain.photo;

import com.dilu.common.base.BaseDO;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : guonima
 * @create : 2017-09-14-21:49
 */
@Alias("photoDO")
public class PhotoDO extends BaseDO {

    private String name;
    private Integer type;
    private String size;
    private BigDecimal price;
    private BigDecimal productionPrice;
    private BigDecimal agencyPrice;
    private String pictureUrl;
    private String productionUrl;
    private String remark;
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(BigDecimal productionPrice) {
        this.productionPrice = productionPrice;
    }

    public BigDecimal getAgencyPrice() {
        return agencyPrice;
    }

    public void setAgencyPrice(BigDecimal agencyPrice) {
        this.agencyPrice = agencyPrice;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProductionUrl() {
        return productionUrl;
    }

    public void setProductionUrl(String productionUrl) {
        this.productionUrl = productionUrl;
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
        return "PhotoDO{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", productionPrice=" + productionPrice +
                ", agencyPrice=" + agencyPrice +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", productionUrl='" + productionUrl + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
