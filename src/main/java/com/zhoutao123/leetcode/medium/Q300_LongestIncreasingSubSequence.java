package com.zhoutao123.leetcode.medium;

/**
 * Q300 最长递增子序列
 *
 * @apiNote 动态规划
 * @apiNote https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Q300_LongestIncreasingSubSequence {
  public static void main(String[] args) {
    System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
  }

  public static int lengthOfLIS(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int j = i;
      while (j + 1 < nums.length && nums[j] <= nums[j + 1]) {
        j++;
      }
      max = Math.max(max, j - i + 1);
    }
    return max;
  }
}
