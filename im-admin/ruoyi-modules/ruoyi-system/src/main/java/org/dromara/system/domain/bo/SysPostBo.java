package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.SysPost;

/**
 * 岗位信息业务对象 sys_post
 *
 * @author Michelle.Chung
 */

@AutoMapper(target = SysPost.class, reverseConvertGenerate = false)
public class SysPostBo extends BaseEntity {

    /**
     * 岗位ID
     */
    private Long postId;

    /**
     * 部门id（单部门）
     */
    @NotNull(message = "部门id不能为空")
    private Long deptId;

    /**
     * 归属部门id（部门树）
     */
    private Long belongDeptId;

    /**
     * 岗位编码
     */
    @NotBlank(message = "岗位编码不能为空")
    @Size(min = 0, max = 64, message = "岗位编码长度不能超过{max}个字符")
    private String postCode;

    /**
     * 岗位名称
     */
    @NotBlank(message = "岗位名称不能为空")
    @Size(min = 0, max = 50, message = "岗位名称长度不能超过{max}个字符")
    private String postName;

    /**
     * 岗位类别编码
     */
    @Size(min = 0, max = 100, message = "类别编码长度不能超过{max}个字符")
    private String postCategory;

    /**
     * 显示顺序
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer postSort;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


    public SysPostBo() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getBelongDeptId() {
        return belongDeptId;
    }

    public void setBelongDeptId(Long belongDeptId) {
        this.belongDeptId = belongDeptId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public Integer getPostSort() {
        return postSort;
    }

    public void setPostSort(Integer postSort) {
        this.postSort = postSort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysPostBo that = (SysPostBo) o;
        return java.util.Objects.equals(postId, that.postId) &&
               java.util.Objects.equals(deptId, that.deptId) &&
               java.util.Objects.equals(belongDeptId, that.belongDeptId) &&
               java.util.Objects.equals(postCode, that.postCode) &&
               java.util.Objects.equals(postName, that.postName) &&
               java.util.Objects.equals(postCategory, that.postCategory) &&
               java.util.Objects.equals(postSort, that.postSort) &&
               java.util.Objects.equals(status, that.status) &&
               java.util.Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), postId, deptId, belongDeptId, postCode, postName, postCategory, postSort, status, remark);
    }
}
