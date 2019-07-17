/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author hieund3
 */
public class Quicksort {

	public static void main(String[] args) {
		int[] arr = {1, 3, 7, 5, 4};
		quicksort(arr);
		basic.BasicTest.printArray(arr);
	}

	private static void quicksort(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length == 1) {
			return;
		}
		quicksort(arr, 0, arr.length);
	}

	private static void quicksort(int[] arr, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int pivotPos = partition(arr, start, end);
		quicksort(arr, start, pivotPos);
		quicksort(arr, pivotPos + 1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end - 1];
		int j = start - 1;
		for (int i = start; i < end - 1; i++) {
			if (arr[i] < pivot) {
				j++;
				swap(arr, j, i);
			}
		}
		j++;
		swap(arr, j, end - 1);
		return j;
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
