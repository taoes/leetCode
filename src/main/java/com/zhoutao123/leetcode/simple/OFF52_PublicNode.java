package com.zhoutao123.leetcode.simple;

import com.zhoutao123.leetcode.ListNode;

import java.util.Stack;

/**
 * OFF052: 两个链表的公共节点
 * <li>执行用时： 3 ms , 在所有 Java 提交中击败了 15.55% 的用户
 * <li>内存消耗： 41.3 MB , 在所有 Java 提交中击败了 41.50% 的用户
 *
 * @apiNote 核心思想: 快慢
 * @apiNote https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class OFF52_PublicNode {
  public static void main(String[] args) {
    ListNode node1 = ListNode.build(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
    ListNode node2 = ListNode.build(new int[] {12, 34, 34, 3, 4, 5, 6, 7, 8});
    // 基于栈的方式实现
    ListNode result = getIntersectionNode(node1, node2);
    result.print();

    // 基于长度
    result = getIntersectionNode2(node1, node2);
    result.print();
  }

  /**
   * 基于栈的方式实现
   *
   * @apiNote 时间复杂度: O(m+n)
   */
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Stack<ListNode> s1 = new Stack<>();
    Stack<ListNode> s2 = new Stack<>();
    while (headA != null) {
      s1.push(headA);
      headA = headA.next;
    }

    while (headB != null) {
      s2.push(headB);
      headB = headB.next;
    }

    ListNode publicNode = null;
    while (!s1.isEmpty() && !s2.isEmpty()) {
      ListNode n1 = s1.pop();
      ListNode n2 = s2.pop();
      if (n1.val == n2.val) {
        publicNode = n1;
        continue;
      }
      return publicNode;
    }
    return publicNode;
  }

  /**
   * 基于快慢指针实现
   *
   * @apiNote 时间复杂度: O(max(m,n))
   */
  public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    int aL = headA.length();
    int bL = headB.length();
    if (aL < bL) {
      int diff = bL - aL;
      while (diff-- > 0) {
        headB = headB.next;
      }
    } else if (aL > bL) {
      int diff = aL - bL;
      while (diff-- > 0) {
        headA = headA.next;
      }
    }

    // 使得指针同步后，平行移动节点
    while (headA.val != headB.val) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }
}
