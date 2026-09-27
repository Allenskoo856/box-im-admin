package org.dromara.system.domain.bo;

import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * 用户密码修改bo
 */
public class SysUserPasswordBo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 旧密码
     */
    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    /**
     * 新密码
     */
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    public SysUserPasswordBo() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
