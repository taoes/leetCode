package com.zhoutao123.leetcode.simple;

import com.zhoutao123.leetcode.TreeNode;

/**
 * Q110: 判断是否是平衡二叉树
 * <li>执行用时： 1 ms , 在所有 Java 提交中击败了 99.98% 的用户
 * <li>内存消耗： 38.5 MB , 在所有 Java 提交中击败了 54.85% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Q110_BalancedBinaryTree {
  public static void main(String[] args) {
    //
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return height(root) >= 0;
  }

  private int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int lh = height(node.left);
    int rh = height(node.right);

    if (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
      return Math.min(lh, rh) + 1;
    } else {
      return -1;
    }
  }
}
