package com.zhoutao123.leetcode.simple;

/**
 * OFF010_Fib
 *
 * @apiNote 递归
 * @apiNote https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class OFF010_Fib {

  public static void main(String[] args) {
    int data = 48;
    System.out.println(fib(data));
  }

  // 动态规划
  public static int fib(int n) {
    if (n == 0) {
      return 0;
    } else if (n < 2) {
      return 1;
    }
    int[] dp = new int[n];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
  }

  // 递归
  public static int fib2(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    return fib2(n - 1) + fib2(n - 2);
  }
}
