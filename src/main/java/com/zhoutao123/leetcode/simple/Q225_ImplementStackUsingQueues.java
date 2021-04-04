package com.zhoutao123.leetcode.simple;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Q225: 使用队列实现栈
 * <li>执行用时： 4 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 36.7 MB , 在所有 Java 提交中击败了 5.03% 的用户
 *
 * @apiNote 核心思想: 双端队列
 * @apiNote https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class Q225_ImplementStackUsingQueues {
  public static void main(String[] args) {
    MyStack obj = new MyStack();
    obj.push(1);
    obj.push(2);
    int param_2 = obj.pop();
    assert param_2 == 2;
    int param_3 = obj.top();

    assert param_3 == 1;

    boolean param_4 = obj.empty();
    assert param_4;
  }

  static class MyStack {
    private final Deque<Integer> deque;
    /** Initialize your data structure here. */
    public MyStack() {
      deque = new LinkedBlockingDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      deque.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      Integer integer = deque.pollFirst();
      assert integer != null;
      return integer;
    }

    /** Get the top element. */
    public int top() {
      Integer integer = deque.pollFirst();
      deque.push(integer);
      assert integer != null;
      return integer;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return deque.isEmpty();
    }
  }
}
