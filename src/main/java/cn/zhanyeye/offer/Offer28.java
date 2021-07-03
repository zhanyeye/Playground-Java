package cn.zhanyeye.offer;

import cn.zhanyeye.common.TreeNode;

/**
 * @Author zhanyeye
 * @Description
 * @Date 28/06/2021
 **/
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    /**
     * 对称二叉树定义： 对于树中 任意两个对称节点 L 和 R ，一定有：
     * L.val == R.val ：即此两对称节点值相等。
     * L.left.val == R.right.val ：即 L 的 左子节点 和 R 的 右子节点 对称；
     * L.right.val == R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
     */
    public boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
