package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Created by hieund3 on 01/08/2021
 */
public class _494_TargetSum {
	public static final _494_TargetSum INSTANCE = new _494_TargetSum();

	public int findTargetSumWays(int[] nums, int S) {
		Map<Integer, Integer> frequenceMap = new HashMap<>();
		frequenceMap.put(-nums[0], 1);
		frequenceMap.put(nums[0], 1 + frequenceMap.getOrDefault(nums[0], 0));
		for (int i = 1; i < nums.length; i++) {
			final Set<Integer> integers = new HashSet<>(frequenceMap.keySet());
			Map<Integer, Integer> newFrequenceMap = new HashMap<>();
			for (Integer key : integers) {
				newFrequenceMap.put(key + nums[i], frequenceMap.get(key) +
					newFrequenceMap.getOrDefault(key + nums[i], 0));
				newFrequenceMap.put(key - nums[i], frequenceMap.get(key) +
					newFrequenceMap.getOrDefault(key - nums[i], 0));
			}
			frequenceMap = newFrequenceMap;
		}
		return frequenceMap.getOrDefault(S, 0);
	}
}
