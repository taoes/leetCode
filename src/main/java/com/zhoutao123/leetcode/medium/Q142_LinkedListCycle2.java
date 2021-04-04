package com.zhoutao123.leetcode.medium;

import com.zhoutao123.leetcode.ListNode;

/**
 * Q142: 环形链表2
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 44.23% 的用户
 *
 * @apiNote 核心思想： 快慢指针
 * @apiNote https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Q142_LinkedListCycle2 {
  public static void main(String[] args) {
    ListNode node = new ListNode(3);

    ListNode node2 = new ListNode(2);
    node.next = node2;

    ListNode result = detectCycle(node);
    if (result == null) {
      System.out.println("无环");
    } else {
      System.out.println("公共点:" + node.val);
    }

    ListNode node3 = new ListNode(1);
    node2.next = node3;

    ListNode node4 = new ListNode(5);
    node3.next = node4;

    ListNode node5 = new ListNode(4);
    node4.next = node5;

    result = detectCycle(node);
    if (result == null) {
      System.out.println("无环");
    } else {
      System.out.println("公共点:" + node.val);
    }

    node5.next = node2;

    result = detectCycle(node);
    if (result == null) {
      System.out.println("无环");
    } else {
      System.out.println("公共点:" + result.val);
    }
  }

  public static ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    // 判断是否是环形链表
    do {
      slow = slow.next;
      if (fast == null || fast.next == null) {
        return null;
      }
      fast = fast.next.next;
    } while (fast != slow);

    // 初始化head
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
