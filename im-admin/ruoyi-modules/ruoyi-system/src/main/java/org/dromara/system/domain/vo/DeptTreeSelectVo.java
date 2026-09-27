package org.dromara.system.domain.vo;

import cn.hutool.core.lang.tree.Tree;
import java.util.List;

/**
 * 角色部门列表树信息
 *
 * @author Michelle.Chung
 */
public class DeptTreeSelectVo {

    /**
     * 选中部门列表
     */
    private List<Long> checkedKeys;

    /**
     * 下拉树结构列表
     */
    private List<Tree<Long>> depts;


    public DeptTreeSelectVo() {
    }

    public List<Long> getCheckedKeys() {
        return checkedKeys;
    }

    public void setCheckedKeys(List<Long> checkedKeys) {
        this.checkedKeys = checkedKeys;
    }

    public List<Tree<Long>> getDepts() {
        return depts;
    }

    public void setDepts(List<Tree<Long>> depts) {
        this.depts = depts;
    }
}
