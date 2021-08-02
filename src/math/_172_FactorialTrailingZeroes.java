package math;

/*
 * Created by hieund3 on 26/06/2021
 */

public class _172_FactorialTrailingZeroes {
	public static final _172_FactorialTrailingZeroes INSTANCE = new _172_FactorialTrailingZeroes();

	public int trailingZeroes(int n) {
		int trailingZeroes = 0;
		while (n >= 5) {
			n = n / 5;
			trailingZeroes += n;
		}
		return trailingZeroes;
	}
}
