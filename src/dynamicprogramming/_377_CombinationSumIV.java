package dynamicprogramming;

/*
 * Created by hieund3 on 26/07/2021
 */
public class _377_CombinationSumIV {
	public static final _377_CombinationSumIV INSTANCE = new _377_CombinationSumIV();

	public int combinationSum4(int[] nums, int target) {
		if (target == 0) {
			return 1;
		}
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] combinationSum = new int[target + 1];
		combinationSum[0] = 1;
		for (int i = 1; i < target + 1; i++) {
			for (int num : nums) {
				if (i - num >= 0) {
					combinationSum[i] += combinationSum[i - num];
				}
			}
		}
		return combinationSum[target];
	}
}
