package com.zhoutao123.leetcode.medium;

/**
 * Q287: 重复数字
 *
 * @apiNote https://leetcode-cn.com/problems/find-the-duplicate-number
 */
public class Q287_FindTheDuplicateNumber {
  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 2, 2};
    int result = findDuplicate(nums);
    System.out.println(result);
  }

  public static int findDuplicate(int[] nums) {
    int fast = 0, slow = 0;
    while (true) {
      fast = nums[nums[fast]];
      slow = nums[slow];
      if (slow == fast) {
        fast = 0;
        while (nums[slow] != nums[fast]) {
          fast = nums[fast];
          slow = nums[slow];
        }
        return nums[slow];
      }
    }
  }
}
