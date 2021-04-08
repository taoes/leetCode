package com.zhoutao123.leetcode;

/** 单线链表节点 */
public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  /** 通过数组构建链表 */
  public static ListNode build(int[] data) {
    if (data == null || data.length == 0){
      return null;
    }
    ListNode node = new ListNode(data[0]);
    ListNode tmp = node;
    for (int i = 1; i < data.length; i++) {
      ListNode newNode = new ListNode(data[i]);
      tmp.next = newNode;
      tmp = newNode;
    }
    return node;
  }

  public int length() {
    int length = 0;
    ListNode node = this;
    while (node != null) {
      length++;
      node = node.next;
    }
    return length;
  }

  /** 打印链表信息 */
  public void print() {
    ListNode node = this;
    while (node != null) {
      System.out.print(node.val + ",");
      node = node.next;
    }
    System.out.println();
  }
}
