package org.dromara.im.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
 * 敏感词对象 im_sensitive_word
 *
 * @author Blue
 * @date 2024-12-22
 */
@TableName("im_sensitive_word")
public class ImSensitiveWord {

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 敏感词内容
     */
    private String content;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private Long creator;


    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


    public ImSensitiveWord() {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
