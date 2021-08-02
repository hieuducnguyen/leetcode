package array;

import java.util.*;

/*
 * Created by hieund3 on 17/07/2021
 */
public class _18_4Sum {
	public static final _18_4Sum INSTANCE = new _18_4Sum();

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> resultSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				final Map<Integer, Integer> secondMap = new HashMap<>();
				for (int k = j + 1; k < nums.length; k++) {
					if (secondMap.containsKey(nums[k])) {
						final List<Integer> arr = Arrays.asList(nums[i], nums[j], nums[k],
							nums[secondMap.get(nums[k])]);
						resultSet.add(arr);
					} else {
						secondMap.put(target - nums[i] - nums[j] - nums[k], k);
					}
				}
			}
		}
		return new ArrayList<>(resultSet);
	}
}
