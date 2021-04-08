package com.zhoutao123.leetcode.difficult;

import com.zhoutao123.leetcode.ListNode;

import java.util.Stack;

// K 个一组翻转链表
public class Q025_ReverseNodesInKGroup {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    ListNode node = ListNode.build(nums);
    node = reverseKGroup(node, 2);
    node.print();
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1) {
      return head;
    }
    // 虚拟头
    ListNode vHead = new ListNode(0);
    vHead.next = head;

    // 栈用来翻转链表
    Stack<ListNode> stack = new Stack<>();

    ListNode tmp = head, stackHead = vHead;
    while (true) {
      // 如果栈的大小小于K，则不断的塞入数据
      if (stack.size() >= k) {
        // 栈的大小满足K个之后，执行翻转
        ListNode pop = null;
        while (!stack.isEmpty()) {
          pop = stack.pop();
          stackHead.next = pop;
          stackHead = pop;
        }
        // 将原栈顶元素的Next指向下一轮循环
        stackHead.next = tmp;
      }
      if (tmp != null) {
        stack.add(tmp);
      }
      // 如果已经结束，并且栈内的元素不多于K个在直接抛弃
      if (tmp == null) {
        break;
      }

      // 如果已经结束，并且栈内的元素大于K，则再来一次翻转
      tmp = tmp.next;
    }
    return vHead.next;
  }
}
