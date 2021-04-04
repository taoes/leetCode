package com.zhoutao123.leetcode.medium;

/**
 * Q005: 最大回文子字符串
 * <li>执行用时： 10 ms , 在所有 Java 提交中击败了 95.46% 的用户
 * <li>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 75.18% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Q005_LongestPalindromicSubString {

  public static void main(String[] args) {
    String data = "a";
    System.out.println(longestPalindrome(data));
  }

  public static String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    char[] chars = s.toCharArray();
    int start = 0, end = 0;
    for (int i = 0; i < chars.length; i++) {
      int len1 = expendAroundCenter(chars, i, i);
      int len2 = expendAroundCenter(chars, i, i + 1);

      int len = Math.max(len1, len2);
      // 判断本次结果是否比上次长，如果是的话，将s向左移动len的一般，将e向右移动len的一半
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  public static int expendAroundCenter(char[] chars, int left, int right) {
    int L = left;
    int R = right;
    while (L >= 0 && R < chars.length && chars[L] == chars[R]) {
      L--;
      R++;
    }
    // 返回长度
    return (R - 1) - (L + 1) + 1;
  }
}
