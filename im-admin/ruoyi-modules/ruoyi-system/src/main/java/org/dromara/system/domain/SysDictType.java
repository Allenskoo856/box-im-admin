package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.dromara.common.tenant.core.TenantEntity;
/**
 * 字典类型表 sys_dict_type
 *
 * @author Lion Li
 */

@TableName("sys_dict_type")
public class SysDictType extends TenantEntity {

    /**
     * 字典主键
     */
    @TableId(value = "dict_id")
    private Long dictId;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 备注
     */
    private String remark;


    public SysDictType() {
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
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
        SysDictType that = (SysDictType) o;
        return java.util.Objects.equals(dictId, that.dictId) &&
               java.util.Objects.equals(dictName, that.dictName) &&
               java.util.Objects.equals(dictType, that.dictType) &&
               java.util.Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), dictId, dictName, dictType, remark);
    }
}
