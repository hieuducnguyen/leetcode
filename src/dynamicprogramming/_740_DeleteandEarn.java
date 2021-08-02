package dynamicprogramming;

import java.util.Arrays;

/*
 * Created by hieund3 on 22/07/2021
 */
public class _740_DeleteandEarn {
	public static final _740_DeleteandEarn INSTANCE = new _740_DeleteandEarn();

	public int deleteAndEarn(int[] nums) {
		Arrays.sort(nums);
		int maxValue = Integer.MIN_VALUE;
		int[] max = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			max[i] = nums[i];
			int j = i - 1;
			while (j >= 0) {
				if (nums[j] == nums[i]) {
					sum += nums[i];
				} else if (nums[j] != nums[i] - 1) {
					break;
				}
				j--;
			}
			if (j >= 0) {
				max[i] = Math.max(sum + max[j], max[i - 1]);
			} else {
				max[i] = i - 1 >= 0 ? Math.max(sum, max[i - 1]) : sum;
			}
			maxValue = Math.max(maxValue, max[i]);
		}
		return maxValue;
	}
}
