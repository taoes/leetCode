package com.zhoutao123.leetcode.simple;

/**
 * Q070:爬楼梯
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 35.1 MB , 在所有 Java 提交中击败了 71.53% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Q070_ClimbingStairs {
  public static void main(String[] args) {
    System.out.println(climbStairs(7));
  }

  public static int climbStairs(int n) {
    if (n <= 0) {
      return -1;
    }
    if (n == 1 || n == 2) {
      return n;
    } else {
      int a = 1;
      int b = 2;
      int sum = 0;
      for (int i = 2; i < n; i++) {
        sum = a + b;
        a = b;
        b = sum;
      }
      return sum;
    }
  }
}
