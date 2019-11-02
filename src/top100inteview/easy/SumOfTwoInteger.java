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
public class SumOfTwoInteger {

	public static void main(String[] args) {
		int a = 10;
		int b = 9;
		int result = getSum(a, b);
		System.out.println("result: " + result);
	}

	private static int getSum(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a ^= b;
			b = carry << 1;
		}
		return a;
	}
}
