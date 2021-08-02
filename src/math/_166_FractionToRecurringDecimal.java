package math;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 26/06/2021
 */
public class _166_FractionToRecurringDecimal {
	public static final _166_FractionToRecurringDecimal INSTANCE = new _166_FractionToRecurringDecimal();

	class Test {
		public Test(int result, int du) {
			this.result = result;
			this.du = du;
		}

		int result;
		int du;
	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		Map<String, Test> map = new HashMap<>();
		int num = numerator / denominator;
		sb.append(num);
		int a = numerator - num * denominator;
		map.put(String.valueOf(numerator), new Test(num, a));
		if (a != 0) {
			sb.append(".");
			a *= 10;
			while (a != 0) {
				if (map.containsKey(String.valueOf(a))) {
					break;
				}
				if (a >= denominator) {
					int b = a / denominator;
					int temp = a - b * denominator;
					map.put(String.valueOf(a), new Test(b, temp * 10));
					a = temp;
					sb.append(b);
				} else {
					sb.append("0");
				}
				a *= 10;
			}
		}
		return sb.toString();
	}
}
