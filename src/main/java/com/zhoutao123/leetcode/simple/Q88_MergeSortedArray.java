package com.zhoutao123.leetcode.simple;

import java.util.Arrays;

/**
 * Q088: 合并两个有序数组
 * <li>执行用时： 1 ms , 在所有 Java 提交中击败了 22.50% 的用户
 * <li>内存消耗： 38.7 MB , 在所有 Java 提交中击败了 21.06% 的用户
 *
 * @apiNote 核心思想: 双指针
 * @apiNote https://leetcode-cn.com/problems/merge-sorted-array
 */
public class Q88_MergeSortedArray {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};

    int m = 3;

    int[] nums2 = {2, 5, 6};
    int n = 3;

    merge(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
      nums1[m++] = nums2[i];
    }
    Arrays.sort(nums1);
  }
}
