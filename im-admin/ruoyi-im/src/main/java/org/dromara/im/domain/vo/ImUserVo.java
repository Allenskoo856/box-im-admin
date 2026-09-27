package org.dromara.im.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.im.domain.ImUser;

import java.util.Date;



/**
 * 用户视图对象 im_user
 *
 * @author Blue
 * @date 2024-12-22
 */
@ExcelIgnoreUnannotated
@AutoMapper(target = ImUser.class)
public class ImUserVo {


    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String userName;

    /**
     * 用户昵称
     */
    @ExcelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 用户头像
     */
    @ExcelProperty(value = "用户头像")
    private String headImage;


    /**
     * 用户头像缩略图
     */
    private String headImageThumb;

    /**
     * 密码(明文)
     */
    private String password;

    /**
     * 性别 0:男 1::女
     */
    @ExcelProperty(value = "性别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=男,1=女")
    private Long sex;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 最后登录时间
     */
    @ExcelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createdTime;

    /**
     *  类型
     */
    private Long type;

    /**
     * 是否被封禁 0:否 1:是
     */
    @ExcelProperty(value = "是否被封禁", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "false=否,true=是")
    private Boolean isBanned;

    /**
     * 被封禁原因
     */
    @ExcelProperty(value = "被封禁原因")
    private String reason;



    public ImUserVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
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
}
