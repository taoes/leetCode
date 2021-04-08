package com.zhoutao123.leetcode.simple;

import com.zhoutao123.leetcode.TreeNode;

/**
 * Q104: 最大深度
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 82.44% 的用户
 *
 * @apiNote 核心思想: 递归
 * @apiNote https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Q104_MaximumDepthOfBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);

    // 1
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(2);
    root.left = left;
    root.right = right;

    // 2

    TreeNode t1 = new TreeNode(123);
    left.left = t1;
    // 3

    TreeNode t2 = new TreeNode(123);
    t1.left = t2;

    System.out.println(maxDepth(root));
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
