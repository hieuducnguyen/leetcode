/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
				map.merge(nums[i][j], new HashSet<>(Arrays.asList(nums[i][j + 1])),
					(u, v) -> {
						u.addAll(v);
						return u;
					});
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

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		if (numCourses == 0 || len == 0) {
			return true;
		}

		// counter for number of prerequisites
		int[] pCounter = new int[numCourses];
		for (int i = 0; i < len; i++) {
			pCounter[prerequisites[i][0]]++;
		}

		//store courses that have no prerequisites
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (pCounter[i] == 0) {
				queue.add(i);
			}
		}

		// number of courses that have no prerequisites
		int numNoPre = queue.size();

		while (!queue.isEmpty()) {
			int top = queue.remove();
			for (int i = 0; i < len; i++) {
				// if a course's prerequisite can be satisfied by a course in queue
				if (prerequisites[i][1] == top) {
					pCounter[prerequisites[i][0]]--;
					if (pCounter[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}

		return numNoPre == numCourses;
	}

	public boolean canFinish1(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		if (numCourses == 0 || len == 0) {
			return true;
		}

		//track visited courses
		int[] visit = new int[numCourses];

		// use the map to store what courses depend on a course 
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int[] a : prerequisites) {
			if (map.containsKey(a[1])) {
				map.get(a[1]).add(a[0]);
			} else {
				ArrayList<Integer> l = new ArrayList<>();
				l.add(a[0]);
				map.put(a[1], l);
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (!canFinishDFS(map, visit, i)) {
				return false;
			}
		}

		return true;
	}

	private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {
		if (visit[i] == -1) {
			return false;
		}
		if (visit[i] == 1) {
			return true;
		}

		visit[i] = -1;
		if (map.containsKey(i)) {
			for (int j : map.get(i)) {
				if (!canFinishDFS(map, visit, j)) {
					return false;
				}
			}
		}

		visit[i] = 1;

		return true;
	}

}
