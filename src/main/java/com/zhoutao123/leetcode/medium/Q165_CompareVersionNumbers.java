package com.zhoutao123.leetcode.medium;

/**
 * Q165: 比较版本号
 * <li>执行用时： 5 ms , 在所有 Java 提交中击败了 5.05% 的用户
 * <li>内存消耗： 37 MB , 在所有 Java 提交中击败了 5.22% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class Q165_CompareVersionNumbers {

  public static void main(String[] args) {
    System.out.println(compareVersion("1.01", "1.001"));
    System.out.println(compareVersion("1.0", "1.0.0.0"));
    System.out.println(compareVersion("0.1", "1.1"));
    System.out.println(compareVersion("1.0.1", "1"));
    System.out.println(compareVersion("7.5.2.4", "7.5.3"));
  }

  public static int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("[.]");
    String[] v2 = version2.split("[.]");
    int i = 0;
    for (; i < Math.min(v1.length, v2.length); i++) {
      int x = Integer.parseInt(v1[i]);
      int y = Integer.parseInt(v2[i]);
      if (x > y) {
        return 1;
      } else if (x < y) {
        return -1;
      }
    }
    if (i == v1.length && i < v2.length) {
      do {
        int last = Integer.parseInt(v2[i]);
        if (last != 0) {
          return -1;
        }
        i++;
      } while (i < v2.length);
      return 0;
    } else if (i == v2.length && i < v1.length) {
      do {
        int last = Integer.parseInt(v1[i]);
        if (last != 0) {
          return 1;
        }
        i++;
      } while (i < v1.length);
      return 0;
    }
    return 0;
  }
}
