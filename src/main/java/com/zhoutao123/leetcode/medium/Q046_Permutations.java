package com.zhoutao123.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Q046: 全排列
 * <li>执行用时： 2 ms , 在所有 Java 提交中击败了 53.06% 的用户
 * <li>内存消耗： 38.7 MB , 在所有 Java 提交中击败了 60.38% 的用户
 *
 * @apiNote 核心思想: 回溯算法
 * @apiNote https://leetcode-cn.com/problems/permutations/
 */
public class Q046_Permutations {
  public static void main(String[] args) {
    int[] data = {1};
    for (List<Integer> list : permute(data)) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, result, new ArrayList<>());
    return result;
  }

  private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> tmp) {
    if (tmp.size() == nums.length) {
      result.add(new ArrayList<>(tmp));
      return;
    }
    for (int num : nums) {
      if (tmp.contains(num)) {
        continue;
      }
      tmp.add(num);
      backtrack(nums, result, tmp);
      tmp.remove(tmp.size() - 1);
    }
  }
}
