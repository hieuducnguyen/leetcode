/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

/**
 *
 * @author HieuDucNguyen
 */
public class BestTimeForStock {

	private static int processs(int[] array) {
		if (array == null || array.length == 0 || array.length == 1) {
			return 0;
		}
		final int len = array.length;
		int[] maxValue = new int[len];
		maxValue[len - 1] = array[len - 1];
		int maxProfit = 0;
		for (int i = (len - 2); i >= 0; i--) {
			maxProfit = Math.max(maxProfit, (maxValue[i + 1] - array[i]));
			maxValue[i] = Math.max(maxValue[i + 1], array[i]);
		}
		return maxProfit;
	}

	private static int process2(int[] array) {
		if (array == null || array.length == 0 || array.length == 1) {
			return 0;
		}
		final int len = array.length;
		int max = array[len - 1];
		int maxProfit = 0;
		for (int i = (len - 2); i >= 0; i--) {
			maxProfit = Math.max(max - array[i], maxProfit);
			max = Math.max(max, array[i]);
		}
		return maxProfit;
	}

	private static int maxProfix(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int tmpMax = prices[prices.length - 1];
		int profit = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] < tmpMax) {
				profit = Math.max(profit, tmpMax - prices[i]);
			} else {
				tmpMax = prices[i];
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] a = new int[]{7, 6, 4, 8, 1};
		int maxProfit = process2(a);
		System.out.println("maxProfit: " + maxProfit);
	}
}
