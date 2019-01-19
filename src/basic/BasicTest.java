package basic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class BasicTest {

	public static BasicTest INSTANCE = new BasicTest();
	public static final int POSITION_NOT_FOUND = -1;

	public static void printArrayInt(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + ":" + a[i] + " | ");
		}
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
		List<Integer> resultList = new ArrayList<Integer>();
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

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
//		List<Integer> intList = new ArrayList();
//		intList.add(1);
//		String a = intList.get(0);
		List<String> stringList = Arrays.asList("1", "2", "3");
		stringList.set(0, "5");
		List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
		list.add("1");
		System.out.println("stringList " + stringList);
		System.out.println("list " + list);
	}

}
