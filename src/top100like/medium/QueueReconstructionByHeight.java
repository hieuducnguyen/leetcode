/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		int[][] people = {{40, 11}, {81, 12}, {32, 60}, {36, 39}, {76, 19}, {11, 37}, {67, 13}, {45, 39}, {99, 0}, {35, 20}, {15, 3}, {62, 13}, {90, 2}, {86, 0}, {26, 13}, {68, 32}, {91, 4}, {23, 24}, {73, 14}, {86, 13}, {62, 6}, {36, 13}, {67, 9}, {39, 57}, {15, 45}, {37, 26}, {12, 88}, {30, 18}, {39, 60}, {77, 2}, {24, 38}, {72, 7}, {96, 1}, {29, 47}, {92, 1}, {67, 28}, {54, 44}, {46, 35}, {3, 85}, {27, 9}, {82, 14}, {29, 17}, {80, 11}, {84, 10}, {5, 59}, {82, 6}, {62, 25}, {64, 29}, {88, 8}, {11, 20}, {83, 0}, {94, 4}, {43, 42}, {73, 9}, {57, 32}, {76, 24}, {14, 67}, {86, 2}, {13, 47}, {93, 1}, {95, 2}, {87, 8}, {8, 78}, {58, 16}, {26, 75}, {26, 15}, {24, 56}, {69, 9}, {42, 22}, {70, 17}, {34, 48}, {26, 39}, {22, 28}, {21, 8}, {51, 44}, {35, 4}, {25, 48}, {78, 18}, {29, 30}, {13, 63}, {68, 8}, {21, 38}, {56, 20}, {84, 14}, {56, 27}, {60, 40}, {98, 0}, {63, 7}, {27, 46}, {70, 13}, {29, 23}, {49, 6}, {5, 64}, {67, 11}, {2, 31}, {59, 8}, {93, 0}, {50, 39}, {84, 6}, {19, 39}};
//		int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
		int[][] result = process1(people);
		basic.BasicTest.printMatrix(result);
	}

	private static int[][] process(int[][] people) {
		int[][] result = new int[people.length][2];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < people.length; i++) {
			final int name = people[i][0];
			map.merge(people[i][1], new ArrayList<>(Arrays.asList(people[i][0])),
				(t, v) -> {
					t.add(name);
					return t;
				});
		}
		for (Integer key : map.keySet()) {
			List<Integer> values = map.get(key);
			Collections.sort(values);
			map.put(key, values);
		}
		System.out.println("map: " + map);
		reconstruct(0, result, map);
		System.out.println("map: " + map);
		return result;
	}

	private static boolean reconstruct(int index, int[][] result, Map<Integer, List<Integer>> map) {
		if (index == result.length) {
			return true;
		}
		for (int i = 0; i <= index; i++) {
			List<Integer> list = map.get(i);
			if (list == null) {
				continue;
			}
			for (int j = 0; j < list.size(); j++) {
				final Integer value = list.get(j);
				if (value == -1) {
					continue;
				}
				result[index][0] = value;
				result[index][1] = i;
				if (!checkRule(index, result)) {
					continue;
				}
				list.set(j, -1);
				if (reconstruct(index + 1, result, map)) {
					return true;
				}
				list.set(j, value);
			}
		}
		return false;
	}

	private static boolean checkRule(int index, int[][] result) {
		int value = result[index][0];
		int heighter = result[index][1];
		int count = 0;
		for (int i = 0; i < index; i++) {
			if (result[i][0] >= value) {
				count++;
			}
		}
		return count == heighter;
	}

	private static int[][] process1(int[][] people) {
		int len = people.length;
		List<List<Point>> result = new ArrayList<>();
		List<List<Point>> tmp;
		List<Point> input = new ArrayList<>();
		int minPos = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < people.length; i++) {
			if (people[i][1] == 0 && people[i][0] < min) {
				minPos = i;
				min = people[i][0];
			}
			input.add(new Point(people[i][0], people[i][1]));
		}
		List<Point> first = new ArrayList<>();
		first.add(new Point(people[minPos][0], people[minPos][1]));
		result.add(first);
		for (int i = 1; i < len; i++) {
			System.out.println(i);
			System.out.println("size: " + result.size());
			tmp = new ArrayList<>(result);
			result = new ArrayList<>();
			for (int j = 0; j < input.size(); j++) {
				for (int k = 0; k < tmp.size(); k++) {
					if (!tmp.get(k).contains(input.get(j))) {
						if (checkRule(tmp.get(k), input.get(j))) {
							List<Point> list = new ArrayList<>(tmp.get(k));
							list.add(input.get(j));
							result.add(list);
						}
					}
				}
			}
		}
		return tranform(result.get(0));
	}

	private static int[][] tranform(List<Point> list) {
		int[][] arr = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			arr[i][0] = list.get(i).x;
			arr[i][1] = list.get(i).y;
		}
		return arr;
	}

	private static boolean checkRule(List<Point> points, Point point) {
		int counter = 0;
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i).x >= point.x) {
				counter++;
			}
		}
		return counter == point.y;
	}

	private static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || obj.getClass() != getClass()) {
				return false;
			}
			Point other = (Point) obj;
			return other.hashCode() == hashCode();
		}

		@Override
		public int hashCode() {
			return this.y * 1100 + x;
		}

		@Override
		public String toString() {
			return String.format("(x==%s, y==%s)", x, y);
		}

	}

}
