package org.dromara.common.core.domain.model;

import jakarta.validation.constraints.NotBlank;
/**
 * 三方登录对象
 *
 * @author Lion Li
 */

public class XcxLoginBody extends LoginBody {

    /**
     * 小程序id(多个小程序时使用)
     */
    private String appid;

    /**
     * 小程序code
     */
    @NotBlank(message = "{xcx.code.not.blank}")
    private String xcxCode;


    public XcxLoginBody() {
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getXcxCode() {
        return xcxCode;
    }

    public void setXcxCode(String xcxCode) {
        this.xcxCode = xcxCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        XcxLoginBody that = (XcxLoginBody) o;
        return java.util.Objects.equals(appid, that.appid) &&
               java.util.Objects.equals(xcxCode, that.xcxCode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), appid, xcxCode);
    }
}
