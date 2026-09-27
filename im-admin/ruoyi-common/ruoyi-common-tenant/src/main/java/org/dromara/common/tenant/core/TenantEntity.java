package org.dromara.common.tenant.core;

import org.dromara.common.mybatis.core.domain.BaseEntity;
/**
 * 租户基类
 *
 * @author Michelle.Chung
 */
public class TenantEntity extends BaseEntity {

    /**
     * 租户编号
     */
    private String tenantId;


    public TenantEntity() {
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TenantEntity that = (TenantEntity) o;
        return java.util.Objects.equals(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), tenantId);
    }
}
