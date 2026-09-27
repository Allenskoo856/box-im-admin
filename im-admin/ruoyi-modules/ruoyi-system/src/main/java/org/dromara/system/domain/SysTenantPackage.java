package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serial;

import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 租户套餐对象 sys_tenant_package
 *
 * @author Michelle.Chung
 */
@TableName("sys_tenant_package")
public class SysTenantPackage extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 租户套餐id
     */
    @TableId(value = "package_id")
    private Long packageId;
    /**
     * 套餐名称
     */
    private String packageName;
    /**
     * 关联菜单id
     */
    private String menuIds;
    /**
     * 备注
     */
    private String remark;
    /**
     * 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）
     */
    private Boolean menuCheckStrictly;
    /**
     * 状态（0正常 1停用）
     */
    private String status;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;


    public SysTenantPackage() {
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    public Boolean isMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    public void setMenuCheckStrictly(Boolean menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysTenantPackage that = (SysTenantPackage) o;
        return java.util.Objects.equals(packageId, that.packageId) &&
               java.util.Objects.equals(packageName, that.packageName) &&
               java.util.Objects.equals(menuIds, that.menuIds) &&
               java.util.Objects.equals(remark, that.remark) &&
               java.util.Objects.equals(menuCheckStrictly, that.menuCheckStrictly) &&
               java.util.Objects.equals(status, that.status) &&
               java.util.Objects.equals(delFlag, that.delFlag);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), packageId, packageName, menuIds, remark, menuCheckStrictly, status, delFlag);
    }
}
