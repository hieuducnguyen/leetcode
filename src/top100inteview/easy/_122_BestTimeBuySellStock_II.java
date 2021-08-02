package top100inteview.easy;

/*
 * Created by hieund3 on 06/07/2021
 */
public class _122_BestTimeBuySellStock_II {
	public static final _122_BestTimeBuySellStock_II INSTANCE = new _122_BestTimeBuySellStock_II();

	public int maxProfit1(int[] prices) {
		int maxProfit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				if (i == prices.length - 1) {
					maxProfit += (prices[i] - minPrice);
				}
			} else {
				if (prices[i - 1] > minPrice) {
					maxProfit += (prices[i - 1] - minPrice);
				}
				minPrice = prices[i];
			}
		}
		return maxProfit;
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				maxProfit += (prices[i] - prices[i - 1]);
			}
		}
		return maxProfit;
	}
}
