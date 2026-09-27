package org.dromara.common.core.domain.model;

import jakarta.validation.constraints.NotBlank;
/**
 * 三方登录对象
 *
 * @author Lion Li
 */

public class SocialLoginBody extends LoginBody {

    /**
     * 第三方登录平台
     */
    @NotBlank(message = "{social.source.not.blank}")
    private String source;

    /**
     * 第三方登录code
     */
    @NotBlank(message = "{social.code.not.blank}")
    private String socialCode;

    /**
     * 第三方登录socialState
     */
    @NotBlank(message = "{social.state.not.blank}")
    private String socialState;


    public SocialLoginBody() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public String getSocialState() {
        return socialState;
    }

    public void setSocialState(String socialState) {
        this.socialState = socialState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SocialLoginBody that = (SocialLoginBody) o;
        return java.util.Objects.equals(source, that.source) &&
               java.util.Objects.equals(socialCode, that.socialCode) &&
               java.util.Objects.equals(socialState, that.socialState);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), source, socialCode, socialState);
    }
}
