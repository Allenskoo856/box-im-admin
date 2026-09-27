package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.dromara.common.core.constant.UserConstants;
import org.dromara.common.tenant.core.TenantEntity;
/**
 * 字典数据表 sys_dict_data
 *
 * @author Lion Li
 */

@TableName("sys_dict_data")
public class SysDictData extends TenantEntity {

    /**
     * 字典编码
     */
    @TableId(value = "dict_code")
    private Long dictCode;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 样式属性（其他样式扩展）
     */
    private String cssClass;

    /**
     * 表格字典样式
     */
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    private String isDefault;

    /**
     * 备注
     */
    private String remark;

    public boolean getDefault() {
        return UserConstants.YES.equals(this.isDefault);
    }


    public SysDictData() {
    }

    public Long getDictCode() {
        return dictCode;
    }

    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getListClass() {
        return listClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public void setDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysDictData that = (SysDictData) o;
        return java.util.Objects.equals(dictCode, that.dictCode) &&
               java.util.Objects.equals(dictSort, that.dictSort) &&
               java.util.Objects.equals(dictLabel, that.dictLabel) &&
               java.util.Objects.equals(dictValue, that.dictValue) &&
               java.util.Objects.equals(dictType, that.dictType) &&
               java.util.Objects.equals(cssClass, that.cssClass) &&
               java.util.Objects.equals(listClass, that.listClass) &&
               java.util.Objects.equals(isDefault, that.isDefault) &&
               java.util.Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), dictCode, dictSort, dictLabel, dictValue, dictType, cssClass, listClass, isDefault, remark);
    }
}
