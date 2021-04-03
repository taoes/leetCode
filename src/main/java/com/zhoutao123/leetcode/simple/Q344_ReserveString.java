package com.zhoutao123.leetcode.simple;

/**
 * Q344. 反转字符串
 * <li>执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <li>内存消耗： 45.2 MB , 在所有 Java 提交中击败了 36.17% 的用户
 *
 * @apiNote 反转字符串
 * @apiNote https://leetcode-cn.com/problems/reverse-string/
 */
public class Q344_ReserveString {

  public static void main(String[] args) {
    char[] chars = "THIS_IS_AN_EXAMPLE".toCharArray();
    reverseString(chars);
    System.out.println(new String(chars));
  }

  public static void reverseString(char[] s) {
    int p1 = 0;
    int p2 = s.length - 1;
    while (p1 < p2) {
      char tmp = s[p1];
      s[p1] = s[p2];
      s[p2] = tmp;
      p1++;
      p2--;
    }
  }
}
