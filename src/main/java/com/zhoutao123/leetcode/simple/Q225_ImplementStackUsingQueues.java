package com.zhoutao123.leetcode.simple;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Q225: 使用队列实现栈
 * <li>执行用时： 4 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 36.7 MB , 在所有 Java 提交中击败了 5.03% 的用户
 *
 * @apiNote 核心思想: 双端队列 & 入栈后，将前面的元素依次出栈在入栈
 * @apiNote https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class Q225_ImplementStackUsingQueues {
  public static void main(String[] args) {
    // 基于双端队列实现
    MyStack obj1 = new MyStack();
    obj1.push(1);
    obj1.push(2);

    assert obj1.pop() == 2;
    assert obj1.pop() == 1;
    assert obj1.empty();

    // 基于队列解决
    MyStack2 obj2 = new MyStack2();
    obj2.push(1);
    obj2.push(2);

    assert obj2.pop() == 2;
    assert obj2.pop() == 1;
    assert obj2.empty();
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

  static class MyStack2 {
    private final Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack2() {
      queue = new LinkedBlockingQueue<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      queue.offer(x);
      int size = queue.size();
      while (size-- > 1) {
        Integer ele = queue.poll();
        queue.offer(ele);
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      Integer integer = queue.poll();
      assert integer != null;
      return integer;
    }

    /** Get the top element. */
    public int top() {
      Integer integer = queue.peek();
      assert integer != null;
      return integer;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return queue.isEmpty();
    }
  }
}
