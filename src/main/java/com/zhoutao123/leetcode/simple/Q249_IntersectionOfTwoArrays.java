package com.zhoutao123.leetcode.simple;

import java.util.*;

/**
 * Q249: 两个数组的交集
 * <li>执行用时： 3 ms , 在所有 Java 提交中击败了 84.46% 的用户
 * <li>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 68.10% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Q249_IntersectionOfTwoArrays {

  public static void main(String[] args) {
    int[] ints = intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2, 3, 3});
    System.out.println(Arrays.toString(ints));
  }

  public static int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }
    Map<Integer, Integer> countMap1 = new HashMap<>(nums1.length);
    Map<Integer, Integer> countMap2 = new HashMap<>(nums2.length);
    for (int i : nums1) {
      if (!countMap1.containsKey(i)) {
        countMap1.put(i, 1);
      }
    }
    for (int i : nums2) {
      if (!countMap2.containsKey(i)) {
        countMap2.put(i, 1);
      }
    }

    List<Integer> result = new ArrayList<>(Math.min(nums1.length, nums2.length));
    for (Integer key : countMap1.keySet()) {
      if (countMap2.containsKey(key)) {
        result.add(key);
      }
    }

    int p = 0;
    int[] numbers = new int[result.size()];
    for (Integer integer : result) {
      numbers[p++] = integer;
    }
    return numbers;
  }
}
