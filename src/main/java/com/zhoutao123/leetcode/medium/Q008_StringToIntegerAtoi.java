package com.zhoutao123.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Q008: 字符串转整数
 * <li>执行用时： 3 ms , 在所有 Java 提交中击败了 47.68% 的用户
 * <li>内存消耗： 38.5 MB , 在所有 Java 提交中击败了 41.99% 的用户
 *
 * @apiNote
 * @apiNote https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Q008_StringToIntegerAtoi {
  public static void main(String[] args) {
    System.out.println(myAtoi(" "));
    System.out.println(myAtoi("42"));
    System.out.println(myAtoi("-42"));
    System.out.println(myAtoi("   -42   "));
    System.out.println(myAtoi("4193 with words"));
    System.out.println(myAtoi("words and 987"));
    System.out.println(myAtoi("-91283472332"));
    System.out.println(myAtoi("9223372036854775808"));
  }

  /** 将字符串转换为整数 */
  public static int myAtoi(String s) {
    if (s.length() == 0 || s.trim().length() == 0) {
      return 0;
    }
    s = s.trim();
    char[] chars = s.toCharArray();
    int flag = 1;
    int sIndex = 0;
    if (chars[0] == '-') {
      flag = -1;
      sIndex++;
    } else if (chars[0] == '+') {
      sIndex++;
    }
    List<Integer> nums = new ArrayList<>();
    for (int i = sIndex; i < chars.length; i++) {
      if (!isNumber(chars[i])) {
        break;
      }
      nums.add(chars[i] - '0');
    }
    // 转换为数字
    double sum = 0;
    for (Integer num : nums) {
      sum = sum * 10 + num;
    }
    sum = sum * flag;
    if (sum > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (sum < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int) sum;
  }

  private static boolean isNumber(char c) {
    int v = c - '0';
    return v >= 0 && v <= 9;
  }
}
