package top100inteview.easy;

/*
 * Created by hieund3 on 30/06/2021
 */
public class _7_ReverseInteger {
	public static final _7_ReverseInteger INSTANCE = new _7_ReverseInteger();

	public int reverse(int x) {
		int num = x;
		int result = 0;
		while (num != 0) {
			int pop = num % 10;
			if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7) {
				return 0;
			}
			if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8) {
				return 0;
			}
			result = result * 10 + pop;
			num /= 10;
		}
		return result;
	}

	public int reverse1(int x) {
		int a = Math.abs(x);
		int result = 0;
		while (a > 0) {
			int newResult = result * 10;
			if (result != 0 && newResult / result != 10) {
				return 0;
			}
			final int b = a % 10;
			result = newResult + b;
			a = a / 10;
		}
		return x > 0 ? result : -result;
	}
}
