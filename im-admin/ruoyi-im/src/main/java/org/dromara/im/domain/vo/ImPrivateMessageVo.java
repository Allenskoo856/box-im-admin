package org.dromara.im.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import com.fhs.core.trans.vo.TransPojo;
import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.im.constant.ImConstant;
import org.dromara.im.domain.ImPrivateMessage;
import org.dromara.im.domain.ImUser;

import java.util.Date;



/**
 * 私聊消息视图对象 im_private_message
 *
 * @author Blue
 * @date 2024-12-22
 */
@ExcelIgnoreUnannotated
@AutoMapper(target = ImPrivateMessage.class)
public class ImPrivateMessageVo implements TransPojo {

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 发送用户id
     */
    @Trans(type = TransType.SIMPLE,dataSource = ImConstant.DS_IM_PLATFORM,target = ImUser.class, fields = "userName", ref = "sendUserName")
    private Long sendId;

    @ExcelProperty(value = "发送用户")
    private String sendUserName;

    /**
     * 接收用户id
     */
    @Trans(type = TransType.SIMPLE,dataSource = ImConstant.DS_IM_PLATFORM,target = ImUser.class, fields = "userName", ref = "recvUserName")
    private Long recvId;

    @ExcelProperty(value = "接收用户")
    private String recvUserName;

    /**
     * 发送内容
     */
    @ExcelProperty(value = "发送内容")
    private String content;

    /**
     * 消息类型
     */
    @ExcelProperty(value = "消息类型")
    private Long type;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private Long status;

    /**
     * 发送时间
     */
    @ExcelProperty(value = "发送时间")
    private Date sendTime;


    public ImPrivateMessageVo() {
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

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public Long getRecvId() {
        return recvId;
    }

    public void setRecvId(Long recvId) {
        this.recvId = recvId;
    }

    public String getRecvUserName() {
        return recvUserName;
    }

    public void setRecvUserName(String recvUserName) {
        this.recvUserName = recvUserName;
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
}
