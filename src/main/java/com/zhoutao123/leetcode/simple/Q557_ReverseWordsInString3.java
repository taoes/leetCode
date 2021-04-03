package com.zhoutao123.leetcode.simple;

/**
 * Q557: 反转字符串中的单词
 * <li>执行用时： 4 ms , 在所有 Java 提交中击败了 92.61% 的用户
 * <li>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 56.64% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 */
public class Q557_ReverseWordsInString3 {
  public static void main(String[] args) {
    String data = "Let's take LeetCode contest";
    System.out.println(reverseWords(data));

    data = "contest";
    System.out.println(reverseWords(data));

    data = "东京 爱情 故事";
    System.out.println(reverseWords(data));
  }

  private static final char SPACE = ' ';

  public static String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    char[] chars = s.toCharArray();
    int p1 = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == SPACE) {
        reserveWord(chars, p1, i - 1);
        p1 = i + 1;
      }
    }
    reserveWord(chars, p1, chars.length - 1);
    return new String(chars);
  }

  private static void reserveWord(char[] chars, int s, int e) {
    int p1 = s;
    int p2 = e;
    while (p1 < p2) {
      char t = chars[p1];
      chars[p1] = chars[p2];
      chars[p2] = t;
      p1++;
      p2--;
    }
  }
}
