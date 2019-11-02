/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author hieund3
 */
public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		int[][] people = {{40, 11}, {81, 12}, {32, 60}, {36, 39}, {76, 19}, {11, 37}, {67, 13}, {45, 39}, {99, 0}, {35, 20}, {15, 3}, {62, 13}, {90, 2}, {86, 0}, {26, 13}, {68, 32}, {91, 4}, {23, 24}, {73, 14}, {86, 13}, {62, 6}, {36, 13}, {67, 9}, {39, 57}, {15, 45}, {37, 26}, {12, 88}, {30, 18}, {39, 60}, {77, 2}, {24, 38}, {72, 7}, {96, 1}, {29, 47}, {92, 1}, {67, 28}, {54, 44}, {46, 35}, {3, 85}, {27, 9}, {82, 14}, {29, 17}, {80, 11}, {84, 10}, {5, 59}, {82, 6}, {62, 25}, {64, 29}, {88, 8}, {11, 20}, {83, 0}, {94, 4}, {43, 42}, {73, 9}, {57, 32}, {76, 24}, {14, 67}, {86, 2}, {13, 47}, {93, 1}, {95, 2}, {87, 8}, {8, 78}, {58, 16}, {26, 75}, {26, 15}, {24, 56}, {69, 9}, {42, 22}, {70, 17}, {34, 48}, {26, 39}, {22, 28}, {21, 8}, {51, 44}, {35, 4}, {25, 48}, {78, 18}, {29, 30}, {13, 63}, {68, 8}, {21, 38}, {56, 20}, {84, 14}, {56, 27}, {60, 40}, {98, 0}, {63, 7}, {27, 46}, {70, 13}, {29, 23}, {49, 6}, {5, 64}, {67, 11}, {2, 31}, {59, 8}, {93, 0}, {50, 39}, {84, 6}, {19, 39}};
//		int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//		int[][] people = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}};
		int[][] result = reconstructQueue(people);
		basic.BasicTest.printMatrix(result);
	}

	private static int[][] reconstructQueue(int[][] people) {
		int[][] result = new int[people.length][2];
		if (people.length < 2) {
			return people;
		}
		Comparator<int[]> sort = (int[] a, int[] b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return -(a[0] - b[0]);
			}
		};
		PriorityQueue<int[]> pq = new PriorityQueue(sort);
		for (int[] person : people) {
			pq.add(person);
		}
		List<int[]> list = new ArrayList<>();
		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			list.add(item[1], item);
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
//		}
		return list.toArray(result);
	}

}
