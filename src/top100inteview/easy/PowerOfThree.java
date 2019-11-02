/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

/**
 *
 * @author hieund3
 */
public class PowerOfThree {

	public static void main(String[] args) {
		int n = 81;
		boolean isPowerOfThree = isPowerOfThree1(n);
		System.out.println("isPowerOfThree: " + isPowerOfThree);
	}

	public static boolean isPowerOfThree(int n) {
		while (n % 3 == 0) {
			n = n / 3;
		}
		return n == 1;
	}

	public static boolean isPowerOfThree1(int n) {
		return 1162261467 % n == 0;
	}
}
