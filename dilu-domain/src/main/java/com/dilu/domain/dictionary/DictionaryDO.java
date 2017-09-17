package com.dilu.domain.dictionary;

import com.dilu.common.base.BaseDO;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author guonima
 * @create 2017-09-15 16:47
 */
@Alias("dictionaryDO")
public class DictionaryDO extends BaseDO {

    private String name; // 字典名称
    private String code; // 字典代码值
    private String type; // 字典类型
    private Integer enabled; // 字典是否有效【0 无效， 1 有效】
    private String remark; // 备注
    private Date createTime;
    private Date modifyTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "DictionaryDO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", enabled=" + enabled +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
