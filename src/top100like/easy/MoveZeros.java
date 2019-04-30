/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

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

	public static void move2(int[] arr, int pos, int end, int numMove) {
		final int left = Math.min(arr.length - numMove, end);
		for (int i = pos; i < left; i++) {
			arr[i] = arr[i + numMove];
		}
	}

	private static void process2(int[] arr) {
		int i = 0, track = -1, move = 0;
		int len = arr.length, numZero = 0;
		while (i < len) {
			if (arr[i] == 0) {
				numZero++;
				if (track == -1) {
					track = i;
				} else {
					move2(arr, track, i - move, move);
					track = i - move;
				}
				move++;
			}
			i++;
		}
		if (track != -1) {
			move2(arr, track, len - numZero, move);
		}
		for (int j = len - numZero; j < arr.length; j++) {
			arr[j] = 0;
		}
	}

	public static void process3(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[counter++] = arr[i];
			}
		}
		for (int i = counter; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{0, 1, 2, 0, 5, 0, 6};
		process3(arr);
		BasicTest.printArrayInt(arr);
	}

}
