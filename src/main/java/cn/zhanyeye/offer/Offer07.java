package cn.zhanyeye.offer;

import cn.zhanyeye.common.*;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Offer07 {
    // 1. 通过前序遍历，我们知道根节点
    // 2. 根据中序遍历，我们知道左右子树的节点数码
    // 3. 同一颗子树前序遍历和中序遍历长度相同
    // 中序遍历中对根节点进行定位时，直接扫描复杂度较高，可以考虑哈希表

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 第1步：构造哈希表，便于快速定位中序遍历的根节点
        // key-value:节点的值-它所在的位置
        int n = inorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        // 第2步：调用一个递归的去创建根节点的方法
        return myBuildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right, int[] inorder, int inorder_left, int inorder_right) {
        // 第3步：递归退出条件，说明子节点为null
        if (preorder_left > preorder_right) {
            return null;
        }
        
        // 第4步：找出根节点，创建根节点
        // 前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 通过哈希表快速找到中序遍历中根节点的位置
        int inorder_root = map.get(preorder[preorder_left]);
        // 求出左子树的长度
        int sizeOfLeftSubTree = inorder_root - inorder_left;
        TreeNode root = new TreeNode(preorder[preorder_left]);

        // 第5步：递归的去创建左子树
        root.left = myBuildTree(preorder, preorder_left + 1, preorder_left + sizeOfLeftSubTree, inorder, inorder_left, inorder_root - 1);
        // 第6步：递归的去创建右子树
        root.right = myBuildTree(preorder, preorder_left + sizeOfLeftSubTree + 1, preorder_right, inorder, inorder_root + 1, inorder_right );

        return root;
    }
}