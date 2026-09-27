package org.dromara.common.core.domain.model;

import jakarta.validation.constraints.NotBlank;
/**
 * 短信登录对象
 *
 * @author Lion Li
 */

public class SmsLoginBody extends LoginBody {

    /**
     * 手机号
     */
    @NotBlank(message = "{user.phonenumber.not.blank}")
    private String phonenumber;

    /**
     * 短信code
     */
    @NotBlank(message = "{sms.code.not.blank}")
    private String smsCode;


    public SmsLoginBody() {
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmsLoginBody that = (SmsLoginBody) o;
        return java.util.Objects.equals(phonenumber, that.phonenumber) &&
               java.util.Objects.equals(smsCode, that.smsCode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), phonenumber, smsCode);
    }
}
