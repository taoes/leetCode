package com.zhoutao123.leetcode.simple;

/**
 * Q268: 丢失的数字
 * <li>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 17.23% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/missing-number/
 */
public class Q268_MissingNumber {

  public static void main(String[] args) {
    int[] data = {3, 0, 1};
    System.out.println(missingNumber(data));

    data = new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1};
    System.out.println(missingNumber2(data));
  }

  public static int missingNumber(int[] nums) {
    int length = nums.length;
    int sum = length * (length + 1) / 2;
    int diffSum = 0;
    for (int num : nums) {
      diffSum += num;
    }
    return sum - diffSum;
  }

  public static int missingNumber2(int[] nums) {
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor ^= nums[i] ^ (i + 1);
    }
    return xor;
  }
}
