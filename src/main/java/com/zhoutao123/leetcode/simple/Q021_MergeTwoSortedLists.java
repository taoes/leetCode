package com.zhoutao123.leetcode.simple;

import com.zhoutao123.leetcode.ListNode;

/**
 * Q021: 合并两个有序链表
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 37.8 MB , 在所有 Java 提交中击败了 72.15% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 */
public class Q021_MergeTwoSortedLists {

  public static void main(String[] args) {
    ListNode listNode1 = ListNode.build(new int[] {1, 3, 5, 7, 9, 11, 13, 15});
    ListNode listNode2 = ListNode.build(new int[] {2, 4, 6, 8, 10, 12, 14});
    listNode1 = mergeTwoLists(listNode1, listNode2);
    listNode1.print();
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    int v1 = l1.val;
    int v2 = l2.val;
    if (v1 < v2) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}
