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
public class FactorialTrailingZeros {

	public static void main(String[] args) {
		int a = 0;
		int numZeros = trailingZeroes(a);
		System.out.println("numZeros: " + numZeros);
	}

	private static int trailingZeroes(int a) {
		double logFiveOfValue = Math.floor(Math.log(a) / Math.log(5));
		int numTrailingZeros = 0;
		for (int i = 1; i <= logFiveOfValue; i++) {
			int tmpNumTrailingZeros = (int) Math.pow(5.0, i);
			numTrailingZeros += (a / tmpNumTrailingZeros);
		}
		return numTrailingZeros;
	}
}
