package dynamicprogramming;

/*
 * Created by hieund3 on 29/07/2021
 */
public class _312_BurstBalloons {
	public static final _312_BurstBalloons INSTANCE = new _312_BurstBalloons();

	public int maxCoins(int[] nums) {
		int[][] maxCoinArr = new int[nums.length][nums.length];
		final int i = maxCoins(nums, 0, nums.length - 1, maxCoinArr, 1, 1);
		return i;
	}

	private int maxCoins(int[] nums, int start, int end, int[][] maxCoinArr, int mostStart, int mostEnd) {
		if (start < 0 || end < 0 || start > nums.length - 1 || end > nums.length - 1
			|| start > end) {
			return 0;
		}
		if (maxCoinArr[start][end] > 0) {
			return maxCoinArr[start][end];
		}
		if (start == end) {
			maxCoinArr[start][end] = nums[start];
			return maxCoinArr[start][end];
		}
		int maxCoin = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			int mostEndLeft = i + 1 <= end ? nums[i + 1] : 1;
			int maxLeft = maxCoins(nums, start, i - 1, maxCoinArr, 1, mostEndLeft);
			int mostStartRight = i - 1 >= start ? nums[i - 1] : 1;
			int maxRight = maxCoins(nums, i + 1, end, maxCoinArr, mostStartRight, 1);
			int left = i == start ? mostStart : nums[i - 1];
			int right = i == end ? mostEnd : nums[i + 1];
			int value = maxLeft + maxRight + left * right * nums[i];
			maxCoin = Math.max(maxCoin, value);
		}
		maxCoinArr[start][end] = maxCoin;
		return maxCoinArr[start][end];
	}
}
