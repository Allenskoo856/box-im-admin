package org.dromara.system.domain.vo;

/**
 * 用户个人信息
 *
 * @author Michelle.Chung
 */
public class ProfileVo {

    /**
     * 用户信息
     */
    private SysUserVo user;

    /**
     * 用户所属角色组
     */
    private String roleGroup;

    /**
     * 用户所属岗位组
     */
    private String postGroup;



    public ProfileVo() {
    }

    public SysUserVo getUser() {
        return user;
    }

    public void setUser(SysUserVo user) {
        this.user = user;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public String getPostGroup() {
        return postGroup;
    }

    public void setPostGroup(String postGroup) {
        this.postGroup = postGroup;
    }
}
