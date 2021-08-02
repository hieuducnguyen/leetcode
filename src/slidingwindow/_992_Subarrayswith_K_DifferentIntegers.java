package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 17/07/2021
 */
public class _992_Subarrayswith_K_DifferentIntegers {
	public static final _992_Subarrayswith_K_DifferentIntegers INSTANCE = new _992_Subarrayswith_K_DifferentIntegers();

	public int subarraysWithKDistinct(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return 0;
		}
		Map<Integer, Integer> frequence = new HashMap<>();
		int startWindow = 0, endWindow = 0, counter = k, result = 0;
		while (endWindow < nums.length) {
			frequence.put(nums[endWindow], frequence.getOrDefault(nums[endWindow], 0) + 1);
			if (frequence.get(nums[endWindow]) == 1) {
				counter--;
			}
			while (counter == 0) {
				if (frequence.get(nums[startWindow]) != null) {
					frequence.put(nums[startWindow], frequence.get(nums[startWindow]) - 1);
					if (frequence.get(nums[startWindow]) == 0) {
						counter++;
					}
				}
				result++;
				startWindow++;
			}
			endWindow++;
		}
		return result;
	}
}
