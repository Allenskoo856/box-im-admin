package org.dromara.web.domain.vo;

import org.dromara.system.domain.vo.SysTenantVo;
import io.github.linpeilie.annotations.AutoMapper;
/**
 * 租户列表
 *
 * @author Lion Li
 */
@AutoMapper(target = SysTenantVo.class)
public class TenantListVo {

    /**
     * 租户编号
     */
    private String tenantId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 域名
     */
    private String domain;


    public TenantListVo() {
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
