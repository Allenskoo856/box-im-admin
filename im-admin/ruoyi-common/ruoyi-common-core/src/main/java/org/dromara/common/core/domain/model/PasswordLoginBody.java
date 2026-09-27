package org.dromara.common.core.domain.model;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import static org.dromara.common.core.constant.UserConstants.*;

/**
 * 密码登录对象
 *
 * @author Lion Li
 */
public class PasswordLoginBody extends LoginBody {

    /**
     * 用户名
     */
    @NotBlank(message = "{user.username.not.blank}")
    @Length(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH, message = "{user.username.length.valid}")
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "{user.password.not.blank}")
    @Length(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH, message = "{user.password.length.valid}")
    private String password;


    public PasswordLoginBody() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PasswordLoginBody that = (PasswordLoginBody) o;
        return java.util.Objects.equals(username, that.username) &&
               java.util.Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), username, password);
    }
}
