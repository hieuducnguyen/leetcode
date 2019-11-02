package basic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class BasicTest {

	public static BasicTest INSTANCE = new BasicTest();
	public static final int POSITION_NOT_FOUND = -1;

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + ":" + a[i] + " | ");
		}
		System.out.println();
	}

	public static void printArray(char[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + ":" + a[i] + " | ");
		}
		System.out.println();
	}

	public static void printArray(double[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + ":" + a[i] + " | ");
		}
		System.out.println();
	}

	public static int maxValArr(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	public static int maxIndArr(int[] a) {
		int max = Integer.MIN_VALUE;
		int ind = -1;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
				ind = i;
			}
		}
		return ind;
	}

	public static int maxValArr(int[] a, int start, int end) {
		int max = Integer.MIN_VALUE;
		for (int i = start; i < end; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	public static int maxIndArr(int[] a, int start, int end) {
		int max = Integer.MIN_VALUE;
		int ind = -1;
		for (int i = start; i < end; i++) {
			if (max < a[i]) {
				max = a[i];
				ind = i;
			}
		}
		return ind;
	}

	public static int minValArr(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}

	public static int minIndArr(int[] a) {
		int min = Integer.MAX_VALUE;
		int ind = -1;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
				ind = i;
			}
		}
		return ind;
	}

	public static int minValArr(int[] a, int start, int end) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}

	public static int minIndArr(int[] a, int start, int end) {
		int min = Integer.MAX_VALUE;
		int ind = -1;
		for (int i = start; i < end; i++) {
			if (min > a[i]) {
				min = a[i];
				ind = i;
			}
		}
		return ind;
	}

	public static List<Integer> convertIntArrayToIntegerList(int[] array) {
		if (array == null) {
			return null;
		}
		List<Integer> resultList = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			resultList.add(array[i]);
		}
		return resultList;
	}

	public static int[] swap2Element(int[] array, int pos, int des) {
		int temp = array[pos];
		array[pos] = array[des];
		array[des] = temp;
		return array;
	}

	public static int swap2Element(int a, int b) {
		return a;
	}

	public static int findInsertPosInList(int value, List<Integer> list) {
		if (list == null) {
			return POSITION_NOT_FOUND;
		}
		if (list.isEmpty()) {
			return 0;
		}
		int len = list.size();
		int left = 0, right = len - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (list.get(mid) < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return left;
	}

	public static class ListNode {

		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return String.format("value=%s", val);
		}

	}

	public static void printListNode(ListNode list) {
		System.out.print("list: ");
		while (list != null) {
			System.out.print(list.val + ", ");
			list = list.next;
		}
	}

	public static void printListNode(Node list) {
		System.out.print("list: ");
		while (list != null) {
			System.out.print(list.toString() + ", ");
			list = list.next;
		}
	}

	public static void printMatrix(int[][] matrix) {
		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			printArray(matrix[i]);
		}
	}

	public static void printMatrix(char[][] matrix) {
		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			printArray(matrix[i]);
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
		printMatrix(matrix);
	}

}
