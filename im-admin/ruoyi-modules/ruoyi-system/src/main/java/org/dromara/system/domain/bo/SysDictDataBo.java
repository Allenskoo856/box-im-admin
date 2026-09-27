package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.SysDictData;

/**
 * 字典数据业务对象 sys_dict_data
 *
 * @author Michelle.Chung
 */

@AutoMapper(target = SysDictData.class, reverseConvertGenerate = false)
public class SysDictDataBo extends BaseEntity {

    /**
     * 字典编码
     */
    private Long dictCode;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 字典标签
     */
    @NotBlank(message = "字典标签不能为空")
    @Size(min = 0, max = 100, message = "字典标签长度不能超过{max}个字符")
    private String dictLabel;

    /**
     * 字典键值
     */
    @NotBlank(message = "字典键值不能为空")
    @Size(min = 0, max = 100, message = "字典键值长度不能超过{max}个字符")
    private String dictValue;

    /**
     * 字典类型
     */
    @NotBlank(message = "字典类型不能为空")
    @Size(min = 0, max = 100, message = "字典类型长度不能超过{max}个字符")
    private String dictType;

    /**
     * 样式属性（其他样式扩展）
     */
    @Size(min = 0, max = 100, message = "样式属性长度不能超过{max}个字符")
    private String cssClass;

    /**
     * 表格回显样式
     */
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    private String isDefault;

    /**
     * 创建部门
     */
    private Long createDept;

    /**
     * 备注
     */
    private String remark;


    public SysDictDataBo() {
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

    public Long getCreateDept() {
        return createDept;
    }

    public void setCreateDept(Long createDept) {
        this.createDept = createDept;
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
        SysDictDataBo that = (SysDictDataBo) o;
        return java.util.Objects.equals(dictCode, that.dictCode) &&
               java.util.Objects.equals(dictSort, that.dictSort) &&
               java.util.Objects.equals(dictLabel, that.dictLabel) &&
               java.util.Objects.equals(dictValue, that.dictValue) &&
               java.util.Objects.equals(dictType, that.dictType) &&
               java.util.Objects.equals(cssClass, that.cssClass) &&
               java.util.Objects.equals(listClass, that.listClass) &&
               java.util.Objects.equals(isDefault, that.isDefault) &&
               java.util.Objects.equals(createDept, that.createDept) &&
               java.util.Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), dictCode, dictSort, dictLabel, dictValue, dictType, cssClass, listClass, isDefault, createDept, remark);
    }
}
