package com.zhoutao123.leetcode.simple;

import java.util.PriorityQueue;

/**
 * OFFICE 40: 获取最小的N个数
 *
 * @apiNote 核心思想: 堆
 * @apiNote https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class OFF40_GetLatestNumbers {
  public static void main(String[] args) {
    int[] data = {3, 2, 1};
    int[] leastNumbers = getLeastNumbers(data, 2);
    for (int leastNumber : leastNumbers) {
      System.out.print(leastNumber + ",");
    }
    System.out.println();
  }

  public static int[] getLeastNumbers(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k == 0) {
      return new int[0];
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i : arr) {
      if (queue.size() < k) {
        queue.offer(i);
      } else if (queue.element() > i) {
        queue.poll();
        queue.offer(i);
      }
    }
    int i = 0;
    int[] nums = new int[queue.size()];
    while (!queue.isEmpty()) {
      nums[i++] = queue.poll();
    }
    return nums;
  }
}
