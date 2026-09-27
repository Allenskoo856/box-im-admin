package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.dromara.common.core.xss.Xss;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.SysNotice;

/**
 * 通知公告业务对象 sys_notice
 *
 * @author Michelle.Chung
 */

@AutoMapper(target = SysNotice.class, reverseConvertGenerate = false)
public class SysNoticeBo extends BaseEntity {

    /**
     * 公告ID
     */
    private Long noticeId;

    /**
     * 公告标题
     */
    @Xss(message = "公告标题不能包含脚本字符")
    @NotBlank(message = "公告标题不能为空")
    @Size(min = 0, max = 50, message = "公告标题不能超过{max}个字符")
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    private String noticeType;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人名称
     */
    private String createByName;


    public SysNoticeBo() {
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysNoticeBo that = (SysNoticeBo) o;
        return java.util.Objects.equals(noticeId, that.noticeId) &&
               java.util.Objects.equals(noticeTitle, that.noticeTitle) &&
               java.util.Objects.equals(noticeType, that.noticeType) &&
               java.util.Objects.equals(noticeContent, that.noticeContent) &&
               java.util.Objects.equals(status, that.status) &&
               java.util.Objects.equals(remark, that.remark) &&
               java.util.Objects.equals(createByName, that.createByName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), noticeId, noticeTitle, noticeType, noticeContent, status, remark, createByName);
    }
}
