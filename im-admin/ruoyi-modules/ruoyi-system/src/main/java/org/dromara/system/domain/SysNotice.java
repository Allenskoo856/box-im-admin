package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.dromara.common.tenant.core.TenantEntity;
/**
 * 通知公告表 sys_notice
 *
 * @author Lion Li
 */
@TableName("sys_notice")
public class SysNotice extends TenantEntity {

    /**
     * 公告ID
     */
    @TableId(value = "notice_id")
    private Long noticeId;

    /**
     * 公告标题
     */
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


    public SysNotice() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysNotice that = (SysNotice) o;
        return java.util.Objects.equals(noticeId, that.noticeId) &&
               java.util.Objects.equals(noticeTitle, that.noticeTitle) &&
               java.util.Objects.equals(noticeType, that.noticeType) &&
               java.util.Objects.equals(noticeContent, that.noticeContent) &&
               java.util.Objects.equals(status, that.status) &&
               java.util.Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), noticeId, noticeTitle, noticeType, noticeContent, status, remark);
    }
}
