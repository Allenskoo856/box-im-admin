package org.dromara.system.domain.bo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.dromara.common.core.constant.RegexConstants;
import org.dromara.common.core.xss.Xss;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.sensitive.annotation.Sensitive;
import org.dromara.common.sensitive.core.SensitiveStrategy;

/**
 * 个人信息业务处理
 *
 * @author Michelle.Chung
 */

public class SysUserProfileBo extends BaseEntity {

    /**
     * 用户昵称
     */
    @Xss(message = "用户昵称不能包含脚本字符")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过{max}个字符")
    private String nickName;

    /**
     * 用户邮箱
     */
    @Sensitive(strategy = SensitiveStrategy.EMAIL)
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过{max}个字符")
    private String email;

    /**
     * 手机号码
     */
    @Pattern(regexp = RegexConstants.MOBILE, message = "手机号格式不正确")
    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;


    public SysUserProfileBo() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysUserProfileBo that = (SysUserProfileBo) o;
        return java.util.Objects.equals(nickName, that.nickName) &&
               java.util.Objects.equals(email, that.email) &&
               java.util.Objects.equals(phonenumber, that.phonenumber) &&
               java.util.Objects.equals(sex, that.sex);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), nickName, email, phonenumber, sex);
    }
}
