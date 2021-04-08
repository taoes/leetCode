package com.zhoutao123.leetcode.medium;

/**
 * Q031: 下一个排列
 *
 * @apiNote https://leetcode-cn.com/problems/next-permutation/
 */
public class Q031_NextPermutation {
  public static void main(String[] args) {
    int[] nums = {1, 3, 2};
    nextPermutation(nums);
    for (int num : nums) {
      System.out.print(num + ",");
    }
    System.out.println();
  }

  public static void nextPermutation(int[] nums) {
    if (nums.length <= 1) {
      return;
    }
    int i = nums.length - 1;
    for (; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        int minIndex = findMin(nums, i);
        int t = nums[minIndex];
        nums[minIndex] = nums[minIndex - 1];
        nums[minIndex - 1] = t;
        return;
      }
    }
    // 说明走到底部了，一直是升序的，那么翻转数组
    if (i == 0) {
      int p1 = 0;
      int p2 = nums.length - 1;
      while (p1 < p2) {
        int t = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = t;
        p1++;
        p2--;
      }
    }
  }

  private static int findMin(int[] nums, int p) {
    int min = p;
    for (int i = p; i < nums.length - 1; i++) {
      if (nums[i] < nums[p]) {
        p = i;
      }
    }
    return min;
  }
}
