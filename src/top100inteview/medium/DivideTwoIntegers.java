/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

/**
 *
 * @author hieund3
 */
public class DivideTwoIntegers {

	static DivideTwoIntegers INSTANCE = new DivideTwoIntegers();

	public static void main(String[] args) {
		int divide = INSTANCE.divide(Integer.MAX_VALUE, -2);
		System.out.println(divide);
	}

	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		int result = 0;
		if (divisor == Integer.MIN_VALUE) {
			if (dividend == Integer.MIN_VALUE) {
				return 1;
			} else {
				return 0;
			}
		}
		boolean carry = false;
		if (dividend == Integer.MIN_VALUE) {
			if (divisor == 1) {
				return Integer.MIN_VALUE;
			} else if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
			carry = true;
			dividend++;
		}
		boolean positive = false;
		if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
			positive = true;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int tmp = divisor;
		int powerOf2 = 1;
		while (dividend - divisor >= 0) {
			if (dividend - tmp >= 0) {
				result += powerOf2;
				dividend -= tmp;
				if (carry) {
					dividend++;
					carry = false;
				}
				powerOf2 <<= 1;
				tmp <<= 1;
			} else {
				powerOf2 >>>= 1;
				tmp >>>= 1;
			}
		}
		return positive ? result : -result;
	}
}
