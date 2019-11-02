/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class CourseScheduleII {

	static CourseScheduleII INSTANCE = new CourseScheduleII();

	public static void main(String[] args) {
		int[][] prerequisites = {{1, 0}, {0, 1}, {3, 1}, {3, 2}};
		int[] order = INSTANCE.findOrder(4, prerequisites);
		basic.BasicTest.printArray(order);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) {
			return new int[]{};
		}
		if (numCourses == 1) {
			return new int[]{0};
		}
		List<Set<Integer>> list = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			list.add(new HashSet<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			list.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		List<Integer> orderCourse = new ArrayList<>();
		Set<Integer> unVisited = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			unVisited.add(i);
		}
		int preSize = -1;
		while (preSize != orderCourse.size()) {
			preSize = orderCourse.size();
			for (Integer course : unVisited) {
				boolean containsAll = orderCourse.containsAll(list.get(course));
				if (containsAll) {
					orderCourse.add(course);
				}
			}
			unVisited.removeAll(orderCourse);
		}
		if (orderCourse.size() == numCourses) {
			int[] course = new int[numCourses];
			for (int i = 0; i < orderCourse.size(); i++) {
				course[i] = orderCourse.get(i);
			}
			return course;
		} else {
			return new int[]{};
		}
	}
}
