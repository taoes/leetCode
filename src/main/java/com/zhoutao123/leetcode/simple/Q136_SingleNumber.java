package com.zhoutao123.leetcode.simple;

/**
 * Q136: 只出现一次的数字
 * <li>执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 38.7 MB , 在所有 Java 提交中击败了 51.44% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/single-number/
 */
public class Q136_SingleNumber {

  public static void main(String[] args) {
    int[] data = {4, 1, 2, 6, 1, 2, 6, 7, 7, 3, 4};
    System.out.println(singleNumber(data));
  }

  public static int singleNumber(int[] nums) {
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }
    return xor;
  }
}
