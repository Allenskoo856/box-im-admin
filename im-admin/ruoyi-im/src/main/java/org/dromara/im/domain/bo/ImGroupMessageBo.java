package org.dromara.im.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.im.domain.ImGroupMessage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 群消息业务对象 im_group_message
 *
 * @author Blue
 * @date 2024-12-22
 */
@AutoMapper(target = ImGroupMessage.class, reverseConvertGenerate = false)
public class ImGroupMessageBo {

    /**
     * id
     */
    private Long id;

    /**
     * 群id
     */
    private Long groupId;

    /**
     * 发送用户id
     */
    private Long sendId;

    /**
     * 发送用户昵称
     */
    private String sendNickName;

    /**
     * 被@用户id列表，逗号分隔
     */
    private String atUserIds;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 
     */
    private Long status;

    /**
     * 消息类型 0:文字 1:图片 2:文件
     */
    private Long type;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 回执消息是否完成
     */
    private Boolean receiptOk;

    /**
     * 是否回执消息
     */
    private Boolean receipt;

    /**
     * 请求参数
     */
    private Map<String, Object> params = new HashMap<>();

    public ImGroupMessageBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getSendId() {
        return sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public String getSendNickName() {
        return sendNickName;
    }

    public void setSendNickName(String sendNickName) {
        this.sendNickName = sendNickName;
    }

    public String getAtUserIds() {
        return atUserIds;
    }

    public void setAtUserIds(String atUserIds) {
        this.atUserIds = atUserIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Boolean getReceiptOk() {
        return receiptOk;
    }

    public Boolean isReceiptOk() {
        return receiptOk;
    }

    public void setReceiptOk(Boolean receiptOk) {
        this.receiptOk = receiptOk;
    }

    public Boolean getReceipt() {
        return receipt;
    }

    public Boolean isReceipt() {
        return receipt;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
