package com.zhoutao123.leetcode.simple;

/**
 * Q415: 字符串相加
 *
 * @apiNote https://leetcode-cn.com/problems/add-strings/
 */
public class Q415_AddStrings {
  public static void main(String[] args) {

    System.out.println(addStrings("89898989", "1212312"));
  }

  public static String addStrings(String num1, String num2) {
    int p1 = num1.length() - 1;
    int p2 = num2.length() - 1;
    int flag = 0;
    StringBuilder builder = new StringBuilder();
    while (p1 >= 0 || p2 >= 0) {
      int x = 0, y = 0;
      if (p1 >= 0) {
        x = num1.charAt(p1) - '0';
      }
      if (p2 >= 0) {
        y = num2.charAt(p2) - '0';
      }
      int tmp = x + y + flag;
      flag = tmp / 10;
      builder.append(tmp % 10);
      p1--;
      p2--;
    }
    if (flag == 1) {
      builder.append("1");
    }

    return builder.reverse().toString();
  }
}
