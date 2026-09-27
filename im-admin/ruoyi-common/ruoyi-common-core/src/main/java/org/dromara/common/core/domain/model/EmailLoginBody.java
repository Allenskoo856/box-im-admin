package org.dromara.common.core.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
/**
 * 邮件登录对象
 *
 * @author Lion Li
 */

public class EmailLoginBody extends LoginBody {

    /**
     * 邮箱
     */
    @NotBlank(message = "{user.email.not.blank}")
    @Email(message = "{user.email.not.valid}")
    private String email;

    /**
     * 邮箱code
     */
    @NotBlank(message = "{email.code.not.blank}")
    private String emailCode;


    public EmailLoginBody() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmailLoginBody that = (EmailLoginBody) o;
        return java.util.Objects.equals(email, that.email) &&
               java.util.Objects.equals(emailCode, that.emailCode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), email, emailCode);
    }
}
