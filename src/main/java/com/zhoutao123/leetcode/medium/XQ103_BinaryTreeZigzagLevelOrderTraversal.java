package com.zhoutao123.leetcode.medium;

import com.zhoutao123.leetcode.TreeNode;

import java.util.List;

/**
 * Q103: 二叉树的层次遍历
 *
 * @apiNote https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class XQ103_BinaryTreeZigzagLevelOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);

    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(2);

    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(33);

    System.out.println(zigzagLevelOrder(root));
  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    return null;
  }
}
