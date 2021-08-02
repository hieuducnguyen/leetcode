package dynamicprogramming;

/*
 * Created by hieund3 on 01/08/2021
 */
public class _714_BestTimetoBuyandSellStockwithTransactionFee {
	public static final _714_BestTimetoBuyandSellStockwithTransactionFee INSTANCE =
		new _714_BestTimetoBuyandSellStockwithTransactionFee();

	public int maxProfit(int[] prices, int fee) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int cash = 0;
		int hold = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			cash = Math.max(cash, hold + prices[i] - fee);
			hold = Math.max(hold, cash - prices[i]);
		}
		return cash;
	}
}
