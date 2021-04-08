package com.zhoutao123.leetcode.simple;

/**
 * Q1212: 股票卖出的最佳实践
 *
 * @apiNote https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Q121_BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    System.out.println(maxProfitWithDp(new int[] {7, 1, 5, 3, 6, 4}));
  }

  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int min = prices[0];
    int result = 0;
    for (int i = 1; i < prices.length; i++) {
      min = Math.min(prices[i], min);
      result = Math.max(prices[i] - min, result);
    }

    return result;
  }

  public static int maxProfitWithDp(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int min = prices[0];
    int[] dp = new int[prices.length];
    dp[0] = 0;
    for (int i = 1; i < prices.length; i++) {
      min = Math.min(prices[i], min);
      dp[i] = Math.max(prices[i] - min, dp[i - 1]);
    }

    return dp[prices.length - 1];
  }
}
