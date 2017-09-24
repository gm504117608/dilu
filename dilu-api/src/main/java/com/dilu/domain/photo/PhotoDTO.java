package com.dilu.domain.photo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author : guonima
 * @create : 2017-09-24-12:00
 */
public class PhotoDTO implements Serializable {

    private Long id;
    private String name;
    private Integer type;
    private String typeName;
    private String size;
    private BigDecimal price;
    private BigDecimal productionPrice;
    private BigDecimal agencyPrice;
    private String pictureUrl;
    private String productionUrl;
    private String remark;
    private Date createTime;

    private List<PhotoDetailDTO> list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public List<PhotoDetailDTO> getList() {
        return list;
    }

    public void setList(List<PhotoDetailDTO> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PhotoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", productionPrice=" + productionPrice +
                ", agencyPrice=" + agencyPrice +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", productionUrl='" + productionUrl + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", list='" + list + '\'' +
                '}';
    }
}
