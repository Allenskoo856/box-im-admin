package org.dromara.common.core.domain.model;

import java.io.Serial;

/**
 * 小程序登录用户身份权限
 *
 * @author Lion Li
 */
public class XcxLoginUser extends LoginUser {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * openid
     */
    private String openid;


    public XcxLoginUser() {
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        XcxLoginUser that = (XcxLoginUser) o;
        return java.util.Objects.equals(openid, that.openid);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), openid);
    }
}
