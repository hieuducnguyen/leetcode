/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import basic.BasicTest;

/**
 *
 * @author HieuDucNguyen
 */
public class QuickSort {

    public static void sortWithEqual(int[] array) {

    }

    private static void sortWithEqual(int[] arr, int left, int right) {
        if (left < right) {
            int partitionsPos = partitionWithEqual(arr, left, right);
            sortWithEqual(arr, left, partitionsPos);
            sortWithEqual(arr, partitionsPos + 1, right);
        }
    }

    private static int partitionWithEqual(int[] arr, int left, int right) {
        int i = left - 1;
        int l = 0;
        int sum = right - left;
        for (int j = left; j < right; j++) {
            if (arr[j] < arr[right - 1]) {
                i++;
                BasicTest.swap2Element(arr, i, j);
            } else if (arr[j] == arr[right - 1]) {
                l++;
            }
        }
        BasicTest.swap2Element(arr, i + 1, right - 1);
        if (l == sum) {
            return (right - 1 + left) / 2;
        }
        return (i + 1);
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionPos = partition(arr, left, right);
            sort(arr, left, partitionPos);
            sort(arr, partitionPos + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left - 1;
        for (int j = left; j < right - 1; j++) {
            if (arr[j] < arr[right - 1]) {
                i++;
                BasicTest.swap2Element(arr, i, j);
            }
        }
        BasicTest.swap2Element(arr, i + 1, right - 1);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 9, 2, 6, 8};
        sort(arr);
        BasicTest.printArrayInt(arr);
    }

}
