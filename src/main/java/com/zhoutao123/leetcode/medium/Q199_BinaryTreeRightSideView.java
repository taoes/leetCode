package com.zhoutao123.leetcode.medium;

import com.zhoutao123.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Q199: 二叉树的右视图
 * <li>执行用时： 8 ms , 在所有 Java 提交中击败了 20.17% 的用户
 * <li>内存消耗： 37.3 MB , 在所有 Java 提交中击败了 24.12% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/binary-tree-right-side-view
 */
public class Q199_BinaryTreeRightSideView {
  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    TreeNode leftNode = new TreeNode(2);
    TreeNode rightNode = new TreeNode(3);

    leftNode.right = new TreeNode(5);
    rightNode.right = new TreeNode(4);

    node.left = leftNode;
    node.right = rightNode;
    List<Integer> integers = rightSideView(node);
    System.out.println(integers);
  }

  public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> a = new ArrayList<>();
    if (root == null) {
      return a;
    }
    Queue<TreeNode> queue = new LinkedBlockingQueue<>();
    queue.offer(root);
    int tmp = 0;
    while (!queue.isEmpty()) {
      int cnt = queue.size();
      while (cnt > 0) {
        TreeNode poll = queue.poll();
        assert poll != null;
        if (poll.left != null) {
          queue.offer(poll.left);
        }
        if (poll.right != null) {
          queue.offer(poll.right);
        }
        tmp = poll.val;
        cnt--;
      }
      a.add(tmp);
    }
    return a;
  }
}
