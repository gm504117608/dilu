package com.dilu.domain.district;

import com.dilu.common.base.BaseDO;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author guonima
 * @create 2017-04-24 14:58
 */
@Alias("districtDO")
public class DistrictDO extends BaseDO {

    private static final long serialVersionUID = -23457819502234L;

    private String code;
    private String description;
    private Integer enabled;
    private Date createTime;

    public DistrictDO() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DistrictDO{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", createTime=" + createTime +
                '}';
    }
}
