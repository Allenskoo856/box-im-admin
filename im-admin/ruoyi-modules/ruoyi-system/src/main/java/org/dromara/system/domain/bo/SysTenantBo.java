package org.dromara.system.domain.bo;

import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.system.domain.SysTenant;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.*;

import java.util.Date;

import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 租户业务对象 sys_tenant
 *
 * @author Michelle.Chung
 */

@AutoMapper(target = SysTenant.class, reverseConvertGenerate = false)
public class SysTenantBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 租户编号
     */
    private String tenantId;

    /**
     * 联系人
     */
    @NotBlank(message = "联系人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String contactUserName;

    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String contactPhone;

    /**
     * 企业名称
     */
    @NotBlank(message = "企业名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String companyName;

    /**
     * 用户名（创建系统用户）
     */
    @NotBlank(message = "用户名不能为空", groups = { AddGroup.class })
    private String username;

    /**
     * 密码（创建系统用户）
     */
    @NotBlank(message = "密码不能为空", groups = { AddGroup.class })
    private String password;

    /**
     * 统一社会信用代码
     */
    private String licenseNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 域名
     */
    private String domain;

    /**
     * 企业简介
     */
    private String intro;

    /**
     * 备注
     */
    private String remark;

    /**
     * 租户套餐编号
     */
    @NotNull(message = "租户套餐不能为空", groups = { AddGroup.class })
    private Long packageId;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 用户数量（-1不限制）
     */
    private Long accountCount;

    /**
     * 租户状态（0正常 1停用）
     */
    private String status;



    public SysTenantBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getContactUserName() {
        return contactUserName;
    }

    public void setContactUserName(String contactUserName) {
        this.contactUserName = contactUserName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Long getAccountCount() {
        return accountCount;
    }

    public void setAccountCount(Long accountCount) {
        this.accountCount = accountCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysTenantBo that = (SysTenantBo) o;
        return java.util.Objects.equals(id, that.id) &&
               java.util.Objects.equals(tenantId, that.tenantId) &&
               java.util.Objects.equals(contactUserName, that.contactUserName) &&
               java.util.Objects.equals(contactPhone, that.contactPhone) &&
               java.util.Objects.equals(companyName, that.companyName) &&
               java.util.Objects.equals(username, that.username) &&
               java.util.Objects.equals(password, that.password) &&
               java.util.Objects.equals(licenseNumber, that.licenseNumber) &&
               java.util.Objects.equals(address, that.address) &&
               java.util.Objects.equals(domain, that.domain) &&
               java.util.Objects.equals(intro, that.intro) &&
               java.util.Objects.equals(remark, that.remark) &&
               java.util.Objects.equals(packageId, that.packageId) &&
               java.util.Objects.equals(expireTime, that.expireTime) &&
               java.util.Objects.equals(accountCount, that.accountCount) &&
               java.util.Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, tenantId, contactUserName, contactPhone, companyName, username, password, licenseNumber, address, domain, intro, remark, packageId, expireTime, accountCount, status);
    }
}
