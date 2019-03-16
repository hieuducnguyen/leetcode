/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like;

import basic.BasicTest;

/**
 *
 * @author HieuDucNguyen
 */
public class MoveZeros {

    public static void process(int[] arr) {
        int end = arr.length;
        int i = 0;
        while (i < end) {
            if (arr[i] == 0) {
                move(arr, i);
                end--;
            } else {
                i++;
            }
        }
    }

    public static void move(int[] arr, int pos) {
        for (int i = pos; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];

        }
        arr[arr.length - 1] = 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        process(arr);
        BasicTest.printArrayInt(arr);
    }
}
