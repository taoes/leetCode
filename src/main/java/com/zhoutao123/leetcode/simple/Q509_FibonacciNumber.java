package com.zhoutao123.leetcode.simple;

/**
 * Q509: 斐波那契数列
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 35 MB , 在所有 Java 提交中击败了 83.47% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/fibonacci-number
 */
public class Q509_FibonacciNumber {

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      System.out.printf("Fib(%s) = %s\n", i, fib(i));
    }
  }

  public static int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n <= 2) {
      return 1;
    }
    int a = 1;
    int b = 1;
    n -= 2;
    while (n-- > 0) {
      int t = a + b;
      a = b;
      b = t;
    }
    return b;
  }
}
