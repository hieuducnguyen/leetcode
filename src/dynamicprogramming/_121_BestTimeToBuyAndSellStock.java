package dynamicprogramming;

/*
 * Created by hieund3 on 19/06/2021
 */
public class _121_BestTimeToBuyAndSellStock {
	public static final _121_BestTimeToBuyAndSellStock INSTANCE = new _121_BestTimeToBuyAndSellStock();

	public int maxProfit1(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] maxSell = new int[prices.length];
		maxSell[prices.length - 1] = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			maxSell[i] = Math.max(maxSell[i + 1], prices[i]);
		}
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			maxProfit = Math.max(maxProfit, maxSell[i + 1] - prices[i]);
		}
		return maxProfit;
	}

	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int maxSell = prices[prices.length - 1];
		int maxProfit = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			maxProfit = Math.max(maxProfit, maxSell - prices[i]);
			maxSell = Math.max(maxSell, prices[i]);
		}
		return maxProfit;
	}

//	public int maxProfit(int[] prices) {
//		if (prices == null || prices.length < 2) {
//			return 0;
//		}
//		int minPrice = prices[0], maxProfit = 0;
//		for (int i = 1; i < prices.length; i++) {
//			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//			minPrice = Math.min(prices[i], minPrice);
//		}
//		return maxProfit;
//	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];
		buy[0] = -prices[0];
		sell[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			buy[i] = Math.max(buy[i - 1], -prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}
		return sell[prices.length - 1];
	}
}
