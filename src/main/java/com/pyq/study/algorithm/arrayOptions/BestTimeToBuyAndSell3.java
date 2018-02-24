package com.pyq.study.algorithm.arrayOptions;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSell3 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for(int i = 0 ; i < prices.length;i++) {
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1,buy1 + prices[i]);
            buy2 = Math.max(buy2,sell1-prices[i]);
            sell2 = Math.max(sell2,buy2 + prices[i]);
        }
        return sell2;
    }
}
