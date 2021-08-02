package top100inteview.easy;

/*
 * Created by hieund3 on 10/07/2021
 */
public class _204_CountPrimes {
	public static final _204_CountPrimes INSTANCE = new _204_CountPrimes();

	public int countPrimes(int n) {
		if (n <= 1) {
			return 0;
		}
		boolean[] notPrimes = new boolean[n];
		int countPrices = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrimes[i]) {
				countPrices++;
				for (int j = 1; j * i < n; j++) {
					notPrimes[i * j] = true;
				}
			}
		}
		return countPrices;
	}
}
