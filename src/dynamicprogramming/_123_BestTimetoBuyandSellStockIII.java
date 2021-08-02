package dynamicprogramming;

/*
 * Created by hieund3 on 01/08/2021
 */
public class _123_BestTimetoBuyandSellStockIII {
	public static final _123_BestTimetoBuyandSellStockIII INSTANCE = new _123_BestTimetoBuyandSellStockIII();

	public int maxProfit(int[] prices) {
		int holdFirst = -prices[0], cashFirst = 0, hold = -prices[0], cash = 0;
		for (int i = 1; i < prices.length; i++) {
			cash = Math.max(cash, hold + prices[i]);
			hold = Math.max(hold, cashFirst - prices[i]);
			cashFirst = Math.max(cashFirst, holdFirst + prices[i]);
			holdFirst = Math.max(holdFirst, -prices[i]);
		}
		return cash;
	}

//	public int maxProfit(int[] prices) {
//		int maxProfit = 0;
//		for (int i = 0; i < prices.length; i++) {
//			final int profitFirst = maxProfit(prices, 0, i - 1);
//			final int profitSecond = maxProfit(prices, i, prices.length - 1);
//			maxProfit = Math.max(maxProfit, profitFirst + profitSecond);
//		}
//		return maxProfit;
//	}
//
//	public int maxProfit(int[] prices, int start, int end) {
//		if (prices == null || start >= end || start < 0) {
//			return 0;
//		}
//		int hold = -prices[start];
//		int cash = 0;
//		for (int i = start + 1; i <= end; i++) {
//			hold = Math.max(hold, -prices[i]);
//			cash = Math.max(cash, hold + prices[i]);
//		}
//		return cash;
//	}
}
