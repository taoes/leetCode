package com.zhoutao123.leetcode.difficult;

/**
 * Q004: 寻找两个正序数组的中位数
 * <li>暂未完成
 *
 * @apiNote https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class Q004_MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    int[] num1 = {1, 2};
    int[] num2 = {3, 4, 5};
    double x = findMedianSortedArrays(num1, num2);
    System.out.println(x);
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0) {
      return mid(nums2);
    } else if (nums2.length == 0) {
      return mid(nums1);
    }
    int l1 = nums1.length;
    int l2 = nums2.length;
    int ls = (l1 + l2);
    int p1 = 0;
    int p2 = 0;

    int pc = 0;
    int pt = ls % 2 == 1 ? ls / 2 : (ls - 1) / 2;
    while (true) {
      if (p1 >= l1 && p2 < l1) {
        p2++;
      } else if (p1 < l1 && p2 >= l2) {
        p1++;
      } else if (nums1[p1] < nums2[p2]) {
        p1++;
      } else {
        p2++;
      }
      pc++;
      if (pc == pt && ls % 2 == 1) {
        return pc == p1 ? nums1[p1] : nums2[p2];
      }
      if (pc == pt && ls % 2 == 0) {
        int num1 = pc == p1 ? nums1[p1] : nums2[p2];
        int num2 = 0;
        if (p1 + 1 < l1 && p2 + 1 < l2) {
          num2 = Math.min(nums1[p1 + 1], nums2[p2 + 1]);
        } else if (p1 + 1 < l1 && p2 + 1 >= l2) {
          num2 = nums1[p1];
        } else if (p1 + 1 >= l1 && p2 + 1 < l2) {
          num2 = nums2[p2];
        }
        return (num1 + num2) / 2.0;
      }
    }
  }

  public static double mid(int[] num) {
    int l = num.length;
    if (l % 2 == 1) {
      return num[l >> 1];
    } else {
      return num[l >> 1] + num[(l >> 1) + 1] / 2.0;
    }
  }
}
