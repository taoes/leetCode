package com.zhoutao123.leetcode.medium;

import java.util.PriorityQueue;

/**
 * Q215: 第K大元素
 * <li>执行用时： 4 ms , 在所有 Java 提交中击败了 59.74% 的用户
 * <li>内存消耗： 38.5 MB , 在所有 Java 提交中击败了 93.30% 的用户
 *
 * @apiNote 核心思想: 最小堆
 * @apiNote https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Q215_kthLargestElement {

  public static void main(String[] args) {
    int[] arrays = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest(arrays, 4));
  }

  /** 寻找集合中第K大的元素 */
  public static Integer findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int num : nums) {
      if (queue.size() < k) {
        queue.add(num);
      } else if (queue.element() < num) {
        queue.poll();
        queue.add(num);
      }
    }
    return queue.poll();
  }
}
