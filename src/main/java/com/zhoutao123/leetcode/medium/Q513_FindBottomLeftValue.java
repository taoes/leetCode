package com.zhoutao123.leetcode.medium;

import com.zhoutao123.leetcode.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Q513: 寻找链表左下角的值
 * <li>执行用时： 9 ms , 在所有 Java 提交中击败了 10.66% 的用户
 * <li>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 47.24% 的用户
 *
 * @apiNote 层次遍历
 * @apiNote https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 */
public class Q513_FindBottomLeftValue {
  public static void main(String[] args) {
    Integer[] data = {1, 2, 3, 4, null, 5, 6, 7};
    TreeNode build = TreeNode.build(data);
    System.out.println(findBottomLeftValue(build));
  }

  public static int findBottomLeftValue(TreeNode root) {
    int c = 0;
    Queue<TreeNode> queue = new LinkedBlockingQueue<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode poll = queue.poll();
      c = poll.val;
      if (poll.right != null) {
        queue.offer(poll.right);
      }

      if (poll.left != null) {
        queue.offer(poll.left);
      }
    }
    return c;
  }
}
