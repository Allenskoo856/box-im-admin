package org.dromara.im.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import com.fhs.core.trans.vo.TransPojo;
import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.im.constant.ImConstant;
import org.dromara.im.domain.ImGroupMember;
import org.dromara.im.domain.ImUser;

import java.io.Serial;
import java.util.Date;



/**
 * 群成员视图对象 im_group_member
 *
 * @author Blue
 * @date 2024-12-22
 */
@ExcelIgnoreUnannotated
@AutoMapper(target = ImGroupMember.class)
public class ImGroupMemberVo implements TransPojo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 群id
     */
    @ExcelProperty(value = "群id")
    private Long groupId;

    /**
     * 用户id
     */
    @Trans(type = TransType.SIMPLE,dataSource = ImConstant.DS_IM_PLATFORM,target = ImUser.class, fields = "userName", ref = "userName")
    private Long userId;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String userName;

    /**
     * 组内显示名称
     */
    @ExcelProperty(value = "组内显示名称")
    private String remarkNickName;

    /**
     * 用户头像
     */
    @ExcelProperty(value = "用户头像")
    private String headImage;

    /**
     * 群名备注
     */
    @ExcelProperty(value = "群名备注")
    private String remarkGroupName;

    /**
     * 是否已退出
     */
    @ExcelProperty(value = "是否已退出")
    private Long quit;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 退出时间
     */
    @ExcelProperty(value = "退出时间")
    private Date quitTime;

    /**
     * 用户昵称
     */
    @ExcelProperty(value = "用户昵称")
    private String userNickName;

    /**
     * 群内显示昵称
     */
    @ExcelProperty(value = "群内显示昵称")
    private String showNickName;


    public ImGroupMemberVo() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemarkNickName() {
        return remarkNickName;
    }

    public void setRemarkNickName(String remarkNickName) {
        this.remarkNickName = remarkNickName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getRemarkGroupName() {
        return remarkGroupName;
    }

    public void setRemarkGroupName(String remarkGroupName) {
        this.remarkGroupName = remarkGroupName;
    }

    public Long getQuit() {
        return quit;
    }

    public void setQuit(Long quit) {
        this.quit = quit;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(Date quitTime) {
        this.quitTime = quitTime;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getShowNickName() {
        return showNickName;
    }

    public void setShowNickName(String showNickName) {
        this.showNickName = showNickName;
    }
}
