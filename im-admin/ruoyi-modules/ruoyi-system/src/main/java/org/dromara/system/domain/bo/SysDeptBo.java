package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.SysDept;

/**
 * 部门业务对象 sys_dept
 *
 * @author Michelle.Chung
 */

@AutoMapper(target = SysDept.class, reverseConvertGenerate = false)
public class SysDeptBo extends BaseEntity {

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    @Size(min = 0, max = 30, message = "部门名称长度不能超过{max}个字符")
    private String deptName;

    /**
     * 部门类别编码
     */
    @Size(min = 0, max = 100, message = "部门类别编码长度不能超过{max}个字符")
    private String deptCategory;

    /**
     * 显示顺序
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer orderNum;

    /**
     * 负责人
     */
    private Long leader;

    /**
     * 联系电话
     */
    @Size(min = 0, max = 11, message = "联系电话长度不能超过{max}个字符")
    private String phone;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过{max}个字符")
    private String email;

    /**
     * 部门状态（0正常 1停用）
     */
    private String status;


    public SysDeptBo() {
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCategory() {
        return deptCategory;
    }

    public void setDeptCategory(String deptCategory) {
        this.deptCategory = deptCategory;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getLeader() {
        return leader;
    }

    public void setLeader(Long leader) {
        this.leader = leader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        SysDeptBo that = (SysDeptBo) o;
        return java.util.Objects.equals(deptId, that.deptId) &&
               java.util.Objects.equals(parentId, that.parentId) &&
               java.util.Objects.equals(deptName, that.deptName) &&
               java.util.Objects.equals(deptCategory, that.deptCategory) &&
               java.util.Objects.equals(orderNum, that.orderNum) &&
               java.util.Objects.equals(leader, that.leader) &&
               java.util.Objects.equals(phone, that.phone) &&
               java.util.Objects.equals(email, that.email) &&
               java.util.Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), deptId, parentId, deptName, deptCategory, orderNum, leader, phone, email, status);
    }
}
