package com.zhoutao123.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题0106: 压缩字符串
 * <li>执行用时： 4 ms , 在所有 Java 提交中击败了 81.72% 的用户
 * <li>内存消耗： 38.1 MB , 在所有 Java 提交中击败了 84.30% 的用户
 *
 * @apiNote https://leetcode-cn.com/problems/compress-string-lcci/
 */
public class M0106_CompressString {

  public static void main(String[] args) {
    String data = "xxxxSSSXXXXXXXfffffooooojggggguuuuummmvOOOOOOeYYYYYaaaaaavvvZZZZ";
    System.out.printf("压缩后的字符串:%s", compressString(data));
  }

  public static String compressString(String S) {
    if (S == null || S.length() < 2) {
      return S;
    }
    char[] chars = S.toCharArray();
    List<Integer> countList = new ArrayList<>();
    char p = chars[0];
    int index = 0;
    for (int i = 1; i < chars.length; i++) {
      char c = chars[i];
      if (c != p) {
        countList.add(++index);
        index = 0;
        p = c;
      } else {
        chars[i] = 0;
        index++;
      }
    }

    countList.add(++index);
    int count = 0;
    StringBuilder builder = new StringBuilder();
    for (char c : chars) {
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        builder.append(c);
        builder.append(countList.get(count++));
        if (builder.length() >= S.length()) {
          return S;
        }
      }
    }
    return builder.toString();
  }
}
