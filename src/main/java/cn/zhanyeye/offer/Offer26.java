package cn.zhanyeye.offer;

import cn.zhanyeye.common.TreeNode;

/**
 * @Author zhanyeye
 * @Description
 * @Date 28/06/2021
 **/
public class Offer26 {
    /**
     * 判断 B 是否为 A的子结构
     * 1. 以节点 A 为根节点的子树包含树 B ，对应 recur(A, B)；
     * 2. 树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)
     * 3. 树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 以A节点为根，递归的比较A和B的结构是否相同 （先序遍历）
     *  终止条件：
     *  1. 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true ；
     *  2. 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
     *  3. 当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
     */
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
