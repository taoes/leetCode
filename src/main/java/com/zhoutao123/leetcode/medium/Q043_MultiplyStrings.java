package com.zhoutao123.leetcode.medium;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Q043: 字符串乘法
 *
 * @apiNote https://leetcode-cn.com/problems/multiply-strings/
 */
public class Q043_MultiplyStrings {

  public static void main(String[] args) {
    System.out.println(multiply("100", "456"));
  }

  public static String multiply(String num1, String num2) {
    int l1 = num1.length();
    int l2 = num2.length();
    int f1 = 1;
    double sum = 0;

    for (int i = l1 - 1; i >= 0; i--) {
      int x = num1.charAt(i) - '0';
      x = x * f1;
      if (x == 0) {
        f1 = 10 * f1;
        continue;
      }
      int f2 = 1;
      for (int j = l2 - 1; j >= 0; j--) {
        int y = num2.charAt(j) - '0';
        y = y * f2;
        sum += (x * y);
        f2 = f2 * 10;
      }
      f1 = f1 * 10;
    }
    return BigDecimal.valueOf(sum).setScale(0g).toString();
  }
}
