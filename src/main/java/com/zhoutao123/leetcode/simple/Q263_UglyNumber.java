package com.zhoutao123.leetcode.simple;

/**
 * Q263: 丑数
 * <li>执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 35.3 MB , 在所有 Java 提交中击败了 88.02% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/ugly-number/
 */
public class Q263_UglyNumber {
  public static void main(String[] args) {
    System.out.println(isUgly(30));
  }

  public static boolean isUgly(int n) {
    if (n < 1) {
      return false;
    }

    while (n % 5 == 0) {
      n = n / 5;
    }

    while (n % 3 == 0) {
      n = n / 3;
    }

    while (n % 2 == 0) {
      n = n >> 1;
    }

    return n == 1;
  }
}
