/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class DailyTemperature {

	public static void main(String[] args) {
		int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		int[] result = process(t);
		basic.BasicTest.printArrayInt(result);
	}

	private static int[] process(int[] t) {
		int[] ans = new int[t.length];
		int[] next = new int[101];
		Arrays.fill(next, Integer.MAX_VALUE);
		for (int i = t.length - 1; i >= 0; i--) {
			int warmerIndex = Integer.MAX_VALUE;
			for (int j = t[i] + 1; j <= 100; j++) {
				if (next[j] < warmerIndex) {
					warmerIndex = next[j];
				}
			}
			if (warmerIndex < Integer.MAX_VALUE) {
				ans[i] = warmerIndex - i;
			}
			next[t[i]] = i;
		}
		return ans;
	}

	public int[] dailyTemperatures(int[] T) {
		return null;
	}

//	private static int insert(DailyTemp tDay) {
//
//	}
	static class DailyTemp {

		public DailyTemp(int t, int day) {
			this.t = t;
			this.day = day;
		}
		int t;
		int day;
	}
}
