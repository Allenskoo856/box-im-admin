package org.dromara.im.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import com.fhs.core.trans.vo.TransPojo;
import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.im.constant.ImConstant;
import org.dromara.im.domain.ImGroup;
import org.dromara.im.domain.ImGroupMessage;
import org.dromara.im.domain.ImUser;

import java.util.Date;



/**
 * 群消息视图对象 im_group_message
 *
 * @author Blue
 * @date 2024-12-22
 */
@ExcelIgnoreUnannotated
@AutoMapper(target = ImGroupMessage.class)
public class ImGroupMessageVo implements TransPojo {

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 群id
     */
    @Trans(type = TransType.SIMPLE,dataSource = ImConstant.DS_IM_PLATFORM,target = ImGroup.class, fields = "name", ref = "groupName")
    private Long groupId;

    @ExcelProperty(value = "群名称")
    private String groupName;

    /**
     * 发送用户id
     */
    @Trans(type = TransType.SIMPLE,dataSource = ImConstant.DS_IM_PLATFORM,target = ImUser.class, fields = "userName", ref = "sendUserName")
    private Long sendId;

    @ExcelProperty(value = "发送用户")
    private String sendUserName;


    /**
     * 发送用户昵称
     */
    @ExcelProperty(value = "发送用户昵称")
    private String sendNickName;

    /**
     * 被@用户id列表，逗号分隔
     */
    @ExcelProperty(value = "被@用户id列表，逗号分隔")
    private String atUserIds;

    /**
     * 发送内容
     */
    @ExcelProperty(value = "发送内容")
    private String content;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long status;

    /**
     * 消息类型 0:文字 1:图片 2:文件
     */
    @ExcelProperty(value = "消息类型 0:文字 1:图片 2:文件")
    private Long type;

    /**
     * 发送时间
     */
    @ExcelProperty(value = "发送时间")
    private Date sendTime;

    /**
     * 回执消息是否完成
     */
    @ExcelProperty(value = "回执消息是否完成")
    private Boolean receiptOk;

    /**
     * 是否回执消息
     */
    @ExcelProperty(value = "是否回执消息")
    private Boolean receipt;


    public ImGroupMessageVo() {
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
}
