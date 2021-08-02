package dynamicprogramming;

/*
 * Created by hieund3 on 23/07/2021
 */
public class _416_PartitionEqualSubsetSum {
	public static final _416_PartitionEqualSubsetSum INSTANCE = new _416_PartitionEqualSubsetSum();

	public boolean canPartition(int[] nums) {
		if (nums.length == 0) {
			return true;
		}
		if (nums.length == 1) {
			return nums[0] == 0;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		boolean[] existNumArr = new boolean[target + 1];
		existNumArr[0] = true;
		for (int i = 0; i < nums.length; i++) {
			for (int j = target; j >= nums[i]; j--) {
				existNumArr[j] = existNumArr[j] | existNumArr[j - nums[i]];
			}
		}
		return existNumArr[target];
	}
}
