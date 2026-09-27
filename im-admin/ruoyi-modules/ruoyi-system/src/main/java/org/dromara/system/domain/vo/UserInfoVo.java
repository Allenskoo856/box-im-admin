package org.dromara.system.domain.vo;

import java.util.Set;

/**
 * 登录用户信息
 *
 * @author Michelle.Chung
 */
public class UserInfoVo {

    /**
     * 用户基本信息
     */
    private SysUserVo user;

    /**
     * 菜单权限
     */
    private Set<String> permissions;

    /**
     * 角色权限
     */
    private Set<String> roles;


    public UserInfoVo() {
    }

    public SysUserVo getUser() {
        return user;
    }

    public void setUser(SysUserVo user) {
        this.user = user;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
