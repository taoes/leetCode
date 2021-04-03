package com.zhoutao123.leetcode.simple;

import java.util.Stack;

/**
 * Q232: 使用队列实现
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 36.2 MB , 在所有 Java 提交中击败了 66.82% 的用户
 *
 * @apiNote 核心思想: 双栈
 * @apiNote https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
public class Q232_ImplementQueueUsingStacks {

  public static void main(String[] args) {
    MyQueue obj = new MyQueue();
    obj.push(1);
    obj.push(2);
    obj.push(3);
    int param_2 = obj.pop();
    assert param_2 == 1;

    int param_3 = obj.peek();
    assert param_3 == 2;

    boolean param_4 = obj.empty();
    assert !param_4;
  }

  static class MyQueue {
    private final Stack<Integer> stack1;

    private final Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      // 如果栈2是空的，将栈1的元素弹出到栈2中
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }

      return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
      // 如果栈2是空的，将栈1的元素弹出到栈2中
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }

      return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stack1.isEmpty() && stack2.isEmpty();
    }
  }
}
