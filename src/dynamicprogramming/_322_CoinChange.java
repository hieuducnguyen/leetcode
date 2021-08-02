package dynamicprogramming;

/*
 * Created by hieund3 on 25/07/2021
 */
public class _322_CoinChange {
	public static final _322_CoinChange INSTANCE = new _322_CoinChange();

	public int coinChange(int[] coins, int amount) {
		if (amount <= 0) {
			return 0;
		}
		int[] coinsNum = new int[amount + 1];
		for (int i = 1; i < amount + 1; i++) {
			int minCoins = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i - coin >= 0 && coinsNum[i - coin] >= 0) {
					minCoins = Math.min(minCoins, coinsNum[i - coin] + 1);
				}
			}
			if (minCoins == Integer.MAX_VALUE) {
				coinsNum[i] = -1;
			} else {
				coinsNum[i] = minCoins;
			}
		}
		return coinsNum[amount];
	}
}
