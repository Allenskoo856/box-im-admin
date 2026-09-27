package org.dromara.system.domain.vo;

import cn.hutool.core.lang.tree.Tree;
import java.util.List;

/**
 * 角色菜单列表树信息
 *
 * @author Michelle.Chung
 */
public class MenuTreeSelectVo {

    /**
     * 选中菜单列表
     */
    private List<Long> checkedKeys;

    /**
     * 菜单下拉树结构列表
     */
    private List<Tree<Long>> menus;


    public MenuTreeSelectVo() {
    }

    public List<Long> getCheckedKeys() {
        return checkedKeys;
    }

    public void setCheckedKeys(List<Long> checkedKeys) {
        this.checkedKeys = checkedKeys;
    }

    public List<Tree<Long>> getMenus() {
        return menus;
    }

    public void setMenus(List<Tree<Long>> menus) {
        this.menus = menus;
    }
}
