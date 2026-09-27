package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.dromara.common.core.constant.RegexConstants;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.SysDictType;

/**
 * 字典类型业务对象 sys_dict_type
 *
 * @author Michelle.Chung
 */

@AutoMapper(target = SysDictType.class, reverseConvertGenerate = false)
public class SysDictTypeBo extends BaseEntity {

    /**
     * 字典主键
     */
    private Long dictId;

    /**
     * 字典名称
     */
    @NotBlank(message = "字典名称不能为空")
    @Size(min = 0, max = 100, message = "字典类型名称长度不能超过{max}个字符")
    private String dictName;

    /**
     * 字典类型
     */
    @NotBlank(message = "字典类型不能为空")
    @Size(min = 0, max = 100, message = "字典类型类型长度不能超过{max}个字符")
    @Pattern(regexp = RegexConstants.DICTIONARY_TYPE, message = "字典类型必须以字母开头，且只能为（小写字母，数字，下滑线）")
    private String dictType;

    /**
     * 备注
     */
    private String remark;



    public SysDictTypeBo() {
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
        SysDictTypeBo that = (SysDictTypeBo) o;
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
