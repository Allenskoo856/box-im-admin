package org.dromara.im.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.im.domain.ImPrivateMessage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 私聊消息业务对象 im_private_message
 *
 * @author Blue
 * @date 2024-12-22
 */
@AutoMapper(target = ImPrivateMessage.class, reverseConvertGenerate = false)
public class ImPrivateMessageBo {

    /**
     * id
     */
    private Long id;

    /**
     * 发送用户id
     */
    private Long sendId;

    /**
     * 接收用户id
     */
    private Long recvId;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 消息类型 0:文字 1:图片 2:文件
     */
    private Long type;

    /**
     * 状态 0:未读 1:已读
     */
    private Long status;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 请求参数
     */
    private Map<String, Object> params = new HashMap<>();


    public ImPrivateMessageBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSendId() {
        return sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public Long getRecvId() {
        return recvId;
    }

    public void setRecvId(Long recvId) {
        this.recvId = recvId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
