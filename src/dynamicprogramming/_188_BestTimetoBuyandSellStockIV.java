package dynamicprogramming;

/*
 * Created by hieund3 on 01/08/2021
 */
public class _188_BestTimetoBuyandSellStockIV {
	public static final _188_BestTimetoBuyandSellStockIV INSTANCE = new _188_BestTimetoBuyandSellStockIV();

	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2 || k < 1) {
			return 0;
		}
		int[] cash = new int[k];
		int[] hold = new int[k];
		for (int i = 0; i < k; i++) {
			hold[i] = -prices[0];
		}
		for (int i = 1; i < prices.length; i++) {
			for (int j = 0; j < k; j++) {
				cash[j] = Math.max(cash[j], hold[j] + prices[i]);
				int cashBefore = j + 1 == k ? 0 : cash[j + 1];
				hold[j] = Math.max(hold[j], cashBefore - prices[i]);
			}
		}
		return cash[0];
	}
}
