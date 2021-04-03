package com.zhoutao123.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q015: 三数之和
 * <li>执行用时： 1672 ms , 在所有 Java 提交中击败了 4.99% 的用户
 * <li>内存消耗： 42.6 MB , 在所有 Java 提交中击败了 39.39% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/3sum/
 */
public class Q015_3sum {

  public static void main(String[] args) {
    //    int[] nums = {-2, 0, 1, 1, 2};
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> lists = threeSum(nums);
    System.out.println(lists);
  }

  private static List<List<Integer>> data = new ArrayList<>();

  public static List<List<Integer>> threeSum(int[] nums) {
    data.clear();
    if (nums == null || nums.length < 3) {
      return data;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int num1 = nums[i];
      int target = -num1;
      find(nums, i + 1, target);
    }
    return data;
  }

  private static void find(int[] nums, int startIndex, int target) {
    // 使用双指针
    int p1 = startIndex;
    int p2 = nums.length - 1;
    while (p1 < p2) {
      int sum = nums[p1] + nums[p2];
      if (sum == target) {
        add(nums[startIndex - 1], nums[p1]);
        p1++;
      } else if (sum > target) {
        p2--;
      } else {
        p1++;
      }
    }
  }

  private static void add(int num1, int num2) {
    for (List<Integer> datum : data) {
      if (datum.get(0) == num1 && datum.get(1) == num2) {
        return;
      }
    }
    data.add(Arrays.asList(num1, num2, -(num1 + num2)));
  }
}
