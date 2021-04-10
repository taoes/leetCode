package com.zhoutao123.leetcode.simple;

import com.zhoutao123.leetcode.ListNode;

/**
 * Q141: 判断链表中是否有环
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 39.6 MB , 在所有 Java 提交中击败了 37.56% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Q141_LinkedListCycle {

  public static void main(String[] args) {
    ListNode build = ListNode.build(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});

    ListNode n1 = build;
    while (n1.next != null) {
      n1 = n1.next;
    }

    assert build.next != null;
    n1.next = build.next.next;

    System.out.println(hasCycle(build));
  }

  public static boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode p1 = head;
    ListNode p2 = head.next;
    while (p1 != p2) {
      p1 = p1.next;
      if (p2 == null || p2.next == null) {
        return false;
      }
      p2 = p2.next.next;
    }
    return true;
  }
}
