package com.zhoutao123.leetcode.simple;

/**
 * 面试题1716: 按摩师
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 35.6 MB , 在所有 Java 提交中击败了 94.45% 的用户
 *
 * @apiNote 核心思想: 动态规划
 * @apiNote https://leetcode-cn.com/problems/the-masseuse-lcci
 */
public class M1716_Massage {

  public static void main(String[] args) {
    System.out.println(massage(new int[] {1, 2, 3, 1}));
    System.out.println(massage(new int[] {2, 7, 9, 3, 1}));
    System.out.println(massage(new int[] {2, 1, 4, 5, 3, 1, 1, 3}));
  }

  public static int massage(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }
}
