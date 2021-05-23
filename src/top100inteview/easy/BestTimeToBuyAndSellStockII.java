/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

/**
 *
 * @author hieund3
 */
public class BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int maxProfit = maxProfit(prices);
		// new line test chery pick
	}

	private static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];
		buy[0] = -prices[0];
		sell[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}
		return sell[prices.length - 1];
	}
}
