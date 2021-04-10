package com.zhoutao123.leetcode.simple;

/**
 * Q053: 最大连续子数组和
 * <li>执行用时： 1 ms , 在所有 Java 提交中击败了 94.73% 的用户
 * <li>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 48.27% 的用户
 *
 * @apiNote 核心思想: 动态规划
 * @apiNote https://leetcode-cn.com/problems/maximum-subarray
 */
public class Q053_MaximumSubarray {

  public static void main(String[] args) {
    System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(maxSubArray(new int[] {1}));
    System.out.println(maxSubArray(new int[] {1, 2, 4, -1}));
  }

  public static int maxSubArray(int[] nums) {
    int max = 0;
    int maxAns = nums[0];
    for (int num : nums) {
      max = Math.max(num, num + max);
      maxAns = Math.max(max, maxAns);
    }
    return maxAns;
  }
}
