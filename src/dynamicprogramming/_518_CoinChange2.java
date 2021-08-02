package dynamicprogramming;

/*
 * Created by hieund3 on 26/07/2021
 */
public class _518_CoinChange2 {
	public static final _518_CoinChange2 INSTANCE = new _518_CoinChange2();

	public int change(int amount, int[] coins) {
		if (coins == null || coins.length == 0 || amount <= 0) {
			return 1;
		}
		int[][] coinsNum = new int[2][amount + 1];
		for (int i = 1; i <= coins.length; i++) {
			coinsNum[i % 2][0] = 1;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j < amount + 1; j++) {
				coinsNum[i % 2][j] = coinsNum[(i - 1) % 2][j];
				if (j - coins[i - 1] >= 0) {
					coinsNum[i % 2][j] += coinsNum[i % 2][j - coins[i - 1]];
				}

			}
		}

		return coinsNum[coins.length % 2][amount];
	}
}
