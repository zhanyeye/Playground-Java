package cn.zhanyeye.offer;

import cn.zhanyeye.common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @Author zhanyeye
 * @Description
 * @Date 28/06/2021
 **/
public class Offer27 {

    /**
     * 递归法
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode mirrorTree = new TreeNode(root.val);
        mirrorTree.left = mirrorTree(root.right);
        mirrorTree.right = mirrorTree(root.left);
        return mirrorTree;
    }

    /**
     * 辅助栈
     * 利用栈（或队列）遍历树的所有节点 nodenode ，并交换每个 nodenode 的左 / 右子节点。
     * 1. 特例处理： 当 root 为空时，直接返回 null ；
     * 2. 初始化： 栈（或队列），本文用栈，并加入根节点 root 。
     * 3. 循环交换： 当栈 stackstack 为空时跳出；
     *      a. 出栈： 记为 node ；
     *      b. 添加子节点： 将 node 左和右子节点入栈；
     *      c. 交换： 交换 node 的左 / 右子节点。
     * 4. 返回值： 返回根节点 root 。
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

}
