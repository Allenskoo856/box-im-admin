package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;

/**
 * 部门表 sys_dept
 *
 * @author Lion Li
 */

@TableName("sys_dept")
public class SysDept extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @TableId(value = "dept_id")
    private Long deptId;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门类别编码
     */
    private String deptCategory;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 负责人
     */
    private Long leader;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门状态:0正常,1停用
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;

    /**
     * 祖级列表
     */
    private String ancestors;


    public SysDept() {
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysDept that = (SysDept) o;
        return java.util.Objects.equals(deptId, that.deptId) &&
               java.util.Objects.equals(parentId, that.parentId) &&
               java.util.Objects.equals(deptName, that.deptName) &&
               java.util.Objects.equals(deptCategory, that.deptCategory) &&
               java.util.Objects.equals(orderNum, that.orderNum) &&
               java.util.Objects.equals(leader, that.leader) &&
               java.util.Objects.equals(phone, that.phone) &&
               java.util.Objects.equals(email, that.email) &&
               java.util.Objects.equals(status, that.status) &&
               java.util.Objects.equals(delFlag, that.delFlag) &&
               java.util.Objects.equals(ancestors, that.ancestors);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), deptId, parentId, deptName, deptCategory, orderNum, leader, phone, email, status, delFlag, ancestors);
    }
}
