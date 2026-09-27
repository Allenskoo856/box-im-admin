package org.dromara.im.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * 群成员对象 im_group_member
 *
 * @author Blue
 * @date 2024-12-22
 */
@TableName("im_group_member")
public class ImGroupMember implements TransPojo {

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 群id
     */
    private Long groupId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 组内显示名称
     */
    private String remarkNickName;

    /**
     * 用户头像
     */
    private String headImage;

    /**
     * 群名备注
     */
    private String remarkGroupName;

    /**
     * 是否已退出
     */
    private Long quit;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 退出时间
     */
    private Date quitTime;

    /**
     * 用户昵称
     */
    private String userNickName;



    public ImGroupMember() {
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
}
