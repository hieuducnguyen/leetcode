package top100inteview.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by hieund3 on 09/07/2021
 */
public class _202_HappyNumber {
	public static final _202_HappyNumber INSTANCE = new _202_HappyNumber();

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int num = n;
		while (num != 1 && !set.contains(num)) {
			set.add(num);
			int result = 0;
			while (num > 0) {
				result += Math.pow(num % 10, 2);
				num /= 10;
			}
			num = result;
			System.out.println("result = " + result);
		}
		return num == 1;
	}
}
