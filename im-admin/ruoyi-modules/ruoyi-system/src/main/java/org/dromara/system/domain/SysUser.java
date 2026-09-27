package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fhs.core.trans.vo.TransPojo;
import org.dromara.common.core.constant.UserConstants;
import org.dromara.common.tenant.core.TenantEntity;
import java.util.Date;

/**
 * 用户对象 sys_user
 *
 * @author Lion Li
 */

@TableName("sys_user")
public class SysUser extends TenantEntity implements TransPojo {

    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户类型（sys_user系统用户）
     */
    private String userType;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    @TableField(
        insertStrategy = FieldStrategy.NOT_EMPTY,
        updateStrategy = FieldStrategy.NOT_EMPTY,
        whereStrategy = FieldStrategy.NOT_EMPTY
    )
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Date loginDate;

    /**
     * 备注
     */
    private String remark;


    public SysUser(Long userId) {
        this.userId = userId;
    }

    public boolean isSuperAdmin() {
        return UserConstants.SUPER_ADMIN_ID.equals(this.userId);
    }


    public SysUser() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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
        SysUser that = (SysUser) o;
        return java.util.Objects.equals(userId, that.userId) &&
               java.util.Objects.equals(deptId, that.deptId) &&
               java.util.Objects.equals(userName, that.userName) &&
               java.util.Objects.equals(nickName, that.nickName) &&
               java.util.Objects.equals(userType, that.userType) &&
               java.util.Objects.equals(email, that.email) &&
               java.util.Objects.equals(phonenumber, that.phonenumber) &&
               java.util.Objects.equals(sex, that.sex) &&
               java.util.Objects.equals(avatar, that.avatar) &&
               java.util.Objects.equals(password, that.password) &&
               java.util.Objects.equals(status, that.status) &&
               java.util.Objects.equals(delFlag, that.delFlag) &&
               java.util.Objects.equals(loginIp, that.loginIp) &&
               java.util.Objects.equals(loginDate, that.loginDate) &&
               java.util.Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), userId, deptId, userName, nickName, userType, email, phonenumber, sex, avatar, password, status, delFlag, loginIp, loginDate, remark);
    }
}
