package com.zhoutao123.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Q001: 两数之和
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 8.33% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/two-sum/
 */
public class Q001_TwoNum {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] result = new Q001_TwoNum().twoSum(nums, 6);
    int[] result2 = new Q001_TwoNum().twoSum2(nums, 6);
    System.out.println(Arrays.toString(result));
    System.out.println(Arrays.toString(result2));
  }

  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return new int[] {};
    }
    Map<Integer, Integer> valueMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (valueMap.containsKey(nums[i])) {
        return new int[] {valueMap.get(nums[i]), i};
      } else {
        valueMap.put(target - nums[i], i);
      }
    }
    return new int[] {};
  }

  public int[] twoSum2(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return new int[] {};
    }
    Arrays.sort(nums);
    int p1 = 0, p2 = nums.length - 1;
    while (p1 < p2) {
      int sum = nums[p1] + nums[p2];
      if (sum == target) {
        return new int[] {p1, p2};
      } else if (sum > target) {
        p2--;
      } else {
        p1++;
      }
    }
    return new int[] {};
  }
}
