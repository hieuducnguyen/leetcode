/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author hieund3
 */
public class CoinChange {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 5};
		int target = 11;
		int result = process2(nums, target);
		System.out.println("result: " + result);
	}

	private static int process(int[] nums, int target) {
		Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Comparator.reverseOrder());
		int result = changeCoin(arr, target, 0);
		return result;
	}

	private static int changeCoin(Integer[] nums, int target, int step) {
		if (target == 0) {
			return step;
		}
		if (target < 0) {
			return -1;
		}
		int num;
		for (int i = 0; i < nums.length; i++) {
			num = changeCoin(nums, target - nums[i], step + 1);
			if (num > 0) {
				return num;
			}
		}
		return -1;
	}

	private static int process2(int[] nums, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, target + 1);
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - nums[j]] + 1);
				}
			}
		}
		return dp[target] == target + 1 ? -1 : dp[target];
	}

	public int coinChange(int[] coins, int amount) {
		if (amount < 1) {
			return 0;
		}
		return coinChange(coins, amount, new int[amount]);
	}

	private int coinChange(int[] coins, int rem, int[] count) {
		if (rem < 0) {
			return -1;
		}
		if (rem == 0) {
			return 0;
		}
		if (count[rem - 1] != 0) {
			return count[rem - 1];
		}
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, rem - coin, count);
			if (res >= 0 && res < min) {
				min = 1 + res;
			}
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}

	public int coinChange1(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
