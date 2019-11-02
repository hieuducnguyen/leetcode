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
public class PowXofN {

	static PowXofN INSTANCE = new PowXofN();

	public static void main(String[] args) {
		double myPow = INSTANCE.myPow(1, -2147483648);
		System.out.println("myPow: " + myPow);
	}

	public double myPow(double x, int n) {
//		if (n == -2147483648) {
//			return 1 / x * myPow(x, n + 1);
//		}
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}
