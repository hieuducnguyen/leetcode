/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.PriorityQueue;

/**
 *
 * @author hieund3
 */
public class KthSmallestElementinASortedMatrix {

	static final KthSmallestElementinASortedMatrix INSTANCE = new KthSmallestElementinASortedMatrix();

	public static void main(String[] args) {
		int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
		int kthSmallest = INSTANCE.kthSmallest(matrix, 6);
		System.out.println("kthSmallest: " + kthSmallest);
	}

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Tuple> heap = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; i++) {
			heap.add(new Tuple(i, 0, matrix[i][0]));
		}
		for (int i = 0; i < k - 1; i++) {
			Tuple item = heap.poll();
			if (item.y == matrix[0].length - 1) {
				continue;
			}
			heap.add(new Tuple(item.x, item.y, matrix[item.x][item.y + 1]));
		}
		return heap.peek().value;
	}

	public class Tuple implements Comparable<Tuple> {

		int x, y, value;

		public Tuple(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Tuple o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return String.format("x: %s, y:%s, value:%s", x, y, value);
		}
	}
}
