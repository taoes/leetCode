package com.zhoutao123.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Q003: 无重复最长子字符串
 * <li>执行用时： 7 ms , 在所有 Java 提交中击败了 79.41% 的用户
 * <li>内存消耗： 39 MB , 在所有 Java 提交中击败了 19.30% 的用户
 *
 * @apiNote 核心思想: 滑动窗口
 * @apiNote https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Q003_LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    String data = "pwwkew";
    System.out.println(lengthOfLongestSubstring(data));
  }

  public static int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    if (s.length() < 2) {
      return s.length();
    }

    char[] chars = s.toCharArray();
    int maxAns = Integer.MIN_VALUE;

    Set<Character> characterSet = new HashSet<>();
    int end = -1;
    for (int i = 0; i < chars.length; i++) {
      if (i != 0) {
        characterSet.remove(chars[i - 1]);
      }
      while (end + 1 < chars.length && !characterSet.contains(chars[end + 1])) {
        characterSet.add(chars[end + 1]);
        end++;
      }
      maxAns = Math.max(end - i + 1, maxAns);
    }
    return maxAns;
  }
}
