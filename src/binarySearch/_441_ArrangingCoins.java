package binarySearch;

/*
 * Created by hieund3 on 17/06/2021
 */
public class _441_ArrangingCoins {
	public static final _441_ArrangingCoins INSTANCE = new _441_ArrangingCoins();

	public int arrangeCoins(int n) {
		long numStair = n;
		long l = 0, r = numStair + 1, m;
		while (l < r) {
			m = (l + r) / 2;
			long value = m * (m + 1) / 2;
			if (value == numStair) {
				return (int) m;
			} else if (value < numStair) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return (int) (r - 1);
	}
}
