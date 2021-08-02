package dynamicprogramming;

/*
 * Created by hieund3 on 20/06/2021
 */
public class _53_MaximumSubarray {
	public static final _53_MaximumSubarray INSTANCE = new _53_MaximumSubarray();

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int lastSum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (lastSum > 0) {
				lastSum += nums[i];
			} else {
				lastSum = nums[i];
			}
			max = Math.max(max, lastSum);
		}
		return max;
	}
}
