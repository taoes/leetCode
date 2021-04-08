package com.zhoutao123.algorithm;

public class DP {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(merge(nums, nums.length - 1, 7));
  }

  public static boolean merge(int[] nums, int n, int target) {
    if (target == 0) {
      return true;
    }
    if (n < 0) {
      return false;
    }
    if (target < nums[n]) {
      return merge(nums, n - 1, target);
    }

    boolean a = merge(nums, n - 1, target - nums[n]);
    boolean b = merge(nums, n - 1, target);
    return a || b;
  }
}
