package org.dromara.im.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.im.domain.ImGroup;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 群业务对象 im_group
 *
 * @author Blue
 * @date 2024-12-22
 */
@AutoMapper(target = ImGroup.class, reverseConvertGenerate = false)
public class ImGroupBo {

    /**
     * id
     */
    private Long id;

    /**
     * 群名字
     */
    private String name;

    /**
     * 群主id
     */
    private Long ownerId;

    /**
     * 群头像
     */
    private String headImage;

    /**
     * 群头像缩略图
     */
    private String headImageThumb;

    /**
     * 群公告
     */
    private String notice;

    /**
     * 是否已解散
     */
    private Boolean dissolve;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 是否被封禁 0:否 1:是
     */
    private Boolean isBanned;

    /**
     * 被封禁原因
     */
    private String reason;

    /**
     * 请求参数
     */
    private Map<String, Object> params = new HashMap<>();



    public ImGroupBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getHeadImageThumb() {
        return headImageThumb;
    }

    public void setHeadImageThumb(String headImageThumb) {
        this.headImageThumb = headImageThumb;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Boolean getDissolve() {
        return dissolve;
    }

    public Boolean isDissolve() {
        return dissolve;
    }

    public void setDissolve(Boolean dissolve) {
        this.dissolve = dissolve;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean isBanned() {
        return isBanned;
    }

    public Boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Boolean isBanned) {
        this.isBanned = isBanned;
    }

    public void setBanned(Boolean isBanned) {
        this.isBanned = isBanned;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
