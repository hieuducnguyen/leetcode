package slidingwindow;

/*
 * Created by hieund3 on 17/07/2021
 */
public class _1004_MaxConsecutiveOnesIII {
	public static final _1004_MaxConsecutiveOnesIII INSTANCE = new _1004_MaxConsecutiveOnesIII();

	public int longestOnes(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int startWindow = 0, endWindow = 0, counter = k, longestOnes = 0;
		while (endWindow < nums.length) {
			if (nums[endWindow] == 0) {
				counter--;
			}
			while (counter < 0) {
				if (nums[startWindow] == 0) {
					counter++;
				}
				startWindow++;
			}
			longestOnes = Math.max(longestOnes, endWindow - startWindow + 1);
			endWindow++;
		}
		return longestOnes;
	}
}
