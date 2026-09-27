package org.dromara.web.domain.vo;

import java.util.List;

/**
 * 登录租户对象
 *
 * @author Michelle.Chung
 */
public class LoginTenantVo {

    /**
     * 租户开关
     */
    private Boolean tenantEnabled;

    /**
     * 租户对象列表
     */
    private List<TenantListVo> voList;


    public LoginTenantVo() {
    }

    public Boolean getTenantEnabled() {
        return tenantEnabled;
    }

    public Boolean isTenantEnabled() {
        return tenantEnabled;
    }

    public void setTenantEnabled(Boolean tenantEnabled) {
        this.tenantEnabled = tenantEnabled;
    }

    public List<TenantListVo> getVoList() {
        return voList;
    }

    public void setVoList(List<TenantListVo> voList) {
        this.voList = voList;
    }
}
