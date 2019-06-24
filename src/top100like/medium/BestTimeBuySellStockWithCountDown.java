/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class BestTimeBuySellStockWithCountDown {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 0, 2};
		int profix = process2(nums);
		System.out.println("profix: " + profix);
	}

	private static int process(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int firstProfit = nums[1] > nums[0] ? nums[1] - nums[0] : 0;
		map.put(1, firstProfit);
		for (int i = 2; i < nums.length; i++) {
			int tempMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] - nums[j] > 0) {
					if (tempMax < ((nums[i] - nums[j]) + map.getOrDefault(j - 2, 0))) {
						tempMax = (nums[i] - nums[j]) + map.getOrDefault(j - 2, 0);
					}
				}
			}
			map.put(i, Math.max(tempMax, map.get(i - 1)));
		}
		return map.get(nums.length - 1);
	}

	private static int process1(int[] prices) {
		int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
		for (int price : prices) {
			prev_buy = buy;
			buy = Math.max(prev_sell - price, prev_buy);
			prev_sell = sell;
			sell = Math.max(prev_buy + price, prev_sell);
		}
		return sell;
	}

	private static int process2(int[] prices) {
		int preBuy = Integer.MIN_VALUE, preSell = 0, preRest = 0, buy = 0, sell = 0, rest = 0;
		for (int i = 0; i < prices.length; i++) {
			int tempPrice = prices[i];
			buy = max(preBuy, preRest - tempPrice, preSell - tempPrice);
			sell = max(preSell, preBuy + tempPrice, preRest + tempPrice);
			rest = max(preBuy, preRest, preSell);
			preBuy = buy;
			preRest = rest;
			preSell = sell;
		}
		return sell;
	}

	private static int max(int num1, int num2, int num3) {
		if (num1 > num2) {
			return Math.max(num1, num3);
		} else {
			return Math.max(num2, num3);
		}
	}
}
