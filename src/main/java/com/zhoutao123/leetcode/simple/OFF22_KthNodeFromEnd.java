package com.zhoutao123.leetcode.simple;

import com.zhoutao123.leetcode.ListNode;

/**
 * OFF22: 链表中倒数第K个节点
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 36.2 MB , 在所有 Java 提交中击败了 75.66% 的用户
 *
 * @apiNote 核心思想: 双指针，快慢指针
 * @apiNote https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class OFF22_KthNodeFromEnd {
  public static void main(String[] args) {
    int[] data = {1};
    ListNode node = ListNode.build(data);
    ListNode kthFromEnd = getKthFromEnd(node, 1);
  }

  public static ListNode getKthFromEnd(ListNode head, int k) {
    ListNode p1 = head;
    ListNode p2 = head;
    while (k-- > 0) {
      p2 = p2.next;
    }

    while (p2 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }

    return p1;
  }
}
