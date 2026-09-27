package org.dromara.system.domain.vo;

import java.util.List;

/**
 * 用户信息
 *
 * @author Michelle.Chung
 */
public class SysUserInfoVo {

    /**
     * 用户信息
     */
    private SysUserVo user;

    /**
     * 角色ID列表
     */
    private List<Long> roleIds;

    /**
     * 角色列表
     */
    private List<SysRoleVo> roles;

    /**
     * 岗位ID列表
     */
    private List<Long> postIds;

    /**
     * 岗位列表
     */
    private List<SysPostVo> posts;


    public SysUserInfoVo() {
    }

    public SysUserVo getUser() {
        return user;
    }

    public void setUser(SysUserVo user) {
        this.user = user;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public List<SysRoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRoleVo> roles) {
        this.roles = roles;
    }

    public List<Long> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<Long> postIds) {
        this.postIds = postIds;
    }

    public List<SysPostVo> getPosts() {
        return posts;
    }

    public void setPosts(List<SysPostVo> posts) {
        this.posts = posts;
    }
}
