/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;

/**
 *
 * @author hieund3
 */
public class PerfectSquares {

	public static void main(String[] args) {
		int n = 12;
		int value = process2(n);
		System.out.println("value: " + value);
	}

	private static int process(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n + 1);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[(int) (i - j * j)] + 1);
			}
		}
		return dp[n];
	}

	private static int process2(int n) {
		return gen(n, n, 0);
	}

	private static int gen(int value, int n, int number) {
		if (value == 0) {
			return number;
		}
		if (value < 0) {
			return -1;
		}
		number++;
		int result = 0;
		for (int i = (int) Math.sqrt(n); i >= 1; i--) {
			result = gen(value - i * i, n, number);
			if (result > 0) {
				break;
			}
		}
		return result;
	}
}
