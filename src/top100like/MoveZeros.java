/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like;

/**
 *
 * @author HieuDucNguyen
 */
public class MoveZeros {

    public static void process(int[] arr) {
        int end = arr.length - 1;
    }

    public static void move(int[] arr, int pos) {
        for (int i = pos; i < arr.length - 1; i++) {
            arr[pos] = arr[pos + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
    }
}
