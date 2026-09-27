package org.dromara.im.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import com.fhs.core.trans.vo.TransPojo;
import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.im.domain.ImSensitiveWord;
import org.dromara.system.domain.SysUser;

import java.util.Date;

/**
 * 敏感词视图对象 im_sensitive_word
 *
 * @author Blue
 * @date 2024-12-22
 */
@ExcelIgnoreUnannotated
@AutoMapper(target = ImSensitiveWord.class)
public class ImSensitiveWordVo implements TransPojo {

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 敏感词内容
     */
    @ExcelProperty(value = "内容")
    private String content;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    @ExcelDictFormat(readConverterExp = "false=否,true=是")
    private Boolean enabled;

    /**
     * 创建者
     */
    @Trans(type = TransType.SIMPLE,target = SysUser.class, fields = "userName", ref = "creatorName")
    private Long creator;


    @ExcelProperty(value = "创建者")
    private String creatorName;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;

    public ImSensitiveWordVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
