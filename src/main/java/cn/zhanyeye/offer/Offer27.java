package cn.zhanyeye.offer;

import cn.zhanyeye.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @Author zhanyeye
 * @Description
 * @Date 28/06/2021
 **/
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode mirrorTree = new TreeNode(root.val);
        mirrorTree.left = mirrorTree(root.right);
        mirrorTree.right = mirrorTree(root.left);
        return mirrorTree;
    }
}
