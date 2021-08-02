package top100inteview.easy;

/*
 * Created by hieund3 on 03/07/2021
 */
public class _69_Sqrtx {
	public static final _69_Sqrtx INSTANCE = new _69_Sqrtx();

	public int mySqrt(int x) {
		int result = 0;
		for (int i = 1 << 16; i > 0; i >>= 1) {
			int next = result | i;
			if (next < x / next) {
				result = next;
			}
			if (next == x / next) {
				return next;
			}
		}
		return result;
	}

	public int mySqrt2(int x) {
		if (x == 0) {
			return 0;
		}
		int l = 0, r = Integer.MAX_VALUE, m;
		while (l < r) {
			m = (l + r) / 2;
			if (m == x / m) {
				return m;
			} else if (m > x / m) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return r - 1;
	}

	public int mySqrt1(int x) {
		long r = 0, l = (long) x + 1, m;
		while (r < l) {
			m = (r + l) / 2;
			if (m * m == x) {
				return (int) m;
			} else if (m * m < x) {
				r = m + 1;
			} else {
				l = m;
			}
		}
		return (int) (r - 1);
	}
}
