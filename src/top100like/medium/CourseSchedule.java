/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class CourseSchedule {

	public static void main(String[] args) {
		int numCourse = 3;
		int[][] nums = new int[][]{{1, 0}, {2, 1}, {0, 2}};
		boolean ret = process(numCourse, nums);
		System.out.println("ret: " + ret);
	}

	private static boolean process(int numCourse, int[][] nums) {
		int n = nums.length;
		if (n <= 1) {
			return true;
		}
		int m = nums[0].length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
//				map.merge(nums[i][j], new HashSet<>(Arrays.asList(nums[i][j + 1])),
//					(u, v) -> {
//						u.addAll(v);
//						return u;
//					});
				if (map.containsKey(nums[i][j])) {
					Set<Integer> get = map.get(nums[i][j]);
					get.add(nums[i][j + 1]);
					map.put(nums[i][j], get);
				} else {
					map.put(nums[i][j], new HashSet<>(Arrays.asList(nums[i][j + 1])));
				}
			}
		}
		System.out.println(map);
		Set<Integer> set = new HashSet<>();
		Set<Integer> passed = new HashSet<>();
		for (Integer value : map.keySet()) {
			if (!passed.contains(value) && isExistHamilton(value, map, set, passed)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isExistHamilton(int pos, Map<Integer, Set<Integer>> map, Set<Integer> set, Set<Integer> passed) {
		if (set.contains(pos)) {
			return true;
		}
		set.add(pos);
		Set<Integer> conditionSet = map.get(pos);
		if (conditionSet != null) {
			for (Integer num : conditionSet) {
				passed.add(num);
				if (isExistHamilton(num, map, set, passed)) {
					return true;
				}
			}
		}

		set.remove(pos);
		return false;
	}

}
