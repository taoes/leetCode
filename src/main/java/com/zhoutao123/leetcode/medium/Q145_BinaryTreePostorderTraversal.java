package com.zhoutao123.leetcode.medium;

import com.zhoutao123.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Q145: 二叉树的后序续遍历
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 36.9 MB , 在所有 Java 提交中击败了 11.87% 的用户
 *
 * @apiNote 核心思想: 递归
 * @apiNote https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 */
public class Q145_BinaryTreePostorderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);

    TreeNode right = new TreeNode(2);
    right.left = new TreeNode(3);
    root.right = right;
    List<Integer> integers = preorderTraversal(root);
    integers.forEach(System.out::print);
  }

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    foreach(root, list);
    return list;
  }

  private static void foreach(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    foreach(root.left, list);
    foreach(root.right, list);
    list.add(root.val);
  }
}
