package com.zhoutao123.leetcode.difficult;

import com.zhoutao123.leetcode.ListNode;

/**
 * Q023: 合并K个排序的链表
 * <li>执行用时： 288 ms , 在所有 Java 提交中击败了 10.20% 的用户
 * <li>内存消耗： 41.1 MB , 在所有 Java 提交中击败了 5.17% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class Q023_MergeKSortedList {
  public static void main(String[] args) {
    ListNode[] nodes = {ListNode.build(new int[] {})};
    ListNode node = mergeKLists(nodes);
    if (node != null) {
      node.print();
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }

    ListNode t = lists[0];
    for (int i = 1; i < lists.length; i++) {
      t = merge(t, lists[i]);
    }
    return t;
  }

  public static ListNode merge(ListNode node1, ListNode node2) {
    if (node1 == null) {
      return node2;
    }
    if (node2 == null) {
      return node1;
    }

    int v1 = node1.val;
    int v2 = node2.val;
    if (v1 < v2) {
      node1.next = merge(node1.next, node2);
      return node1;
    } else {
      node2.next = merge(node1, node2.next);
      return node2;
    }
  }
}
