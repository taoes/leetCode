package com.zhoutao123.leetcode.simple;

import com.zhoutao123.leetcode.ListNode;

/**
 * Q206: 反转链表
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 53.69% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Q206_ReverseLinkedList {

  public static void main(String[] args) {
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
    ListNode node = ListNode.build(data);

    node = reverseList(node);
    node.print();
  }

  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = null;
    ListNode cur = head;

    while (cur != null) {
      ListNode nextTemp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = nextTemp;
    }
    return pre;
  }
}
