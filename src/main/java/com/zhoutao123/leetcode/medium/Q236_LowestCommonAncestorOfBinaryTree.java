package com.zhoutao123.leetcode.medium;

import com.zhoutao123.leetcode.TreeNode;

import java.util.Objects;

/**
 * Q236: 二叉树的最近公共祖先
 * <li>执行用时： 8 ms , 在所有 Java 提交中击败了 47.04% 的用户 内存消耗： 41 MB , 在所有 Java 提交中击败了 7.82% 的用户}
 *
 * @apiNote https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Q236_LowestCommonAncestorOfBinaryTree {
  public static void main(String[] args) {
    TreeNode root = TreeNode.build(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    System.out.println(lowestCommonAncestor(root, new TreeNode(8), new TreeNode(7)));
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (Objects.equals(root, p) || Objects.equals(root, q)) {
      return root;
    }

    if (root != null) {
      TreeNode lNode = lowestCommonAncestor(root.left, p, q);
      TreeNode rNode = lowestCommonAncestor(root.right, p, q);
      if (lNode != null && rNode != null) {
        return root;
      } else if (lNode == null) {
        return rNode;
      } else {
        return lNode;
      }
    }
    return null;
  }
}
