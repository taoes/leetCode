package com.zhoutao123.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * OFF39: 数组中出现次数超过一半的数字
 * <li>方法1执行用时： 16 ms , 在所有 Java 提交中击败了 21.63% 的用户
 * <li>方法1内存消耗： 43.5 MB , 在所有 Java 提交中击败了 24.33% 的用户
 * <li>方法2执行用时： 3 ms , 在所有 Java 提交中击败了 33.79% 的用户
 * <li>方法2内存消耗： 44.4 MB , 在所有 Java 提交中击败了 5.03% 的用户
 *
 * @apiNote
 *     https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 */
public class OFF39_CountHalfNumber {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 2, 2, 2, 5, 4, 2,2};
    System.out.println(majorityElement(numbers));
    System.out.println(majorityElement2(numbers));
  }

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        Integer count = map.get(num);
        map.put(num, count + 1);
      } else {
        map.put(num, 1);
      }
    }
    int size = nums.length >> 1;
    for (Integer integer : map.keySet()) {
      int count = map.get(integer);
      if (count >= size) {
        return integer;
      }
    }
    return Integer.MIN_VALUE;
  }

  /** 摩尔投票法 */
  public static int majorityElement2(int[] nums) {
    Integer card = null;
    int count = 0;
    for (int num : nums) {
      if (count == 0) {
        card = num;
      }
      count += (card == num) ? 1 : -1;
    }
    return card;
  }
}
