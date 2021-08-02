package dynamicprogramming;

/*
 * Created by hieund3 on 01/08/2021
 */
public class _309_BestTimetoBuyandSellStockwithCooldown {
	public static final _309_BestTimetoBuyandSellStockwithCooldown INSTANCE =
		new _309_BestTimetoBuyandSellStockwithCooldown();

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] cash = new int[prices.length];
		int[] hold = new int[prices.length];
		cash[0] = 0;
		hold[0] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
			if (i == 1) {
				hold[i] = Math.max(hold[i - 1], -prices[i]);
			} else {
				hold[i] = Math.max(hold[i - 1], cash[i - 2] - prices[i]);
			}
		}
		return cash[prices.length - 1];
	}
}
