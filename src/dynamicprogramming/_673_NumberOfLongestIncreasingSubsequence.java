package dynamicprogramming;

/*
 * Created by hieund3 on 24/07/2021
 */
public class _673_NumberOfLongestIncreasingSubsequence {
	public static final _673_NumberOfLongestIncreasingSubsequence INSTANCE =
		new _673_NumberOfLongestIncreasingSubsequence();

	public int findNumberOfLIS(int[] nums) {
		Struct[] LISArr = new Struct[nums.length];
		int LIS = -1, numberOfLIS = 0;
		for (int i = 0; i < nums.length; i++) {
			int LISEachStep = 1, numsOfLISEachStep = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (LISEachStep == (LISArr[j].LIS + 1)) {
						numsOfLISEachStep += LISArr[j].numberOfLIS;
					} else if (LISEachStep < LISArr[j].LIS + 1) {
						numsOfLISEachStep = LISArr[j].numberOfLIS;
						LISEachStep = LISArr[j].LIS + 1;
					}
				}
			}
			LISArr[i] = new Struct(LISEachStep, numsOfLISEachStep);
			if (LISEachStep > LIS) {
				numberOfLIS = numsOfLISEachStep;
				LIS = LISEachStep;
			} else if (LISEachStep == LIS) {
				numberOfLIS += numsOfLISEachStep;
			}
		}
		return numberOfLIS;
	}

	class Struct {
		int LIS;
		int numberOfLIS;

		public Struct(int LIS, int numberOfLIS) {
			this.LIS = LIS;
			this.numberOfLIS = numberOfLIS;
		}
	}
}
