/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmh.c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class GenBinarySequence {

	public static void main(String[] args) {
		int n = 4;
		List<String> text = process(n);
		System.out.println(text);
	}

	private static void test1() {
		int[] arr = new int[]{1, 0, 1, 1, 1, 0, 1};
		int i = arr.length - 1;
		while (i >= 0 && arr[i] == 1) {
			i--;
		}
		if (i >= 0) {
			arr[i] = 1;
			for (int j = i + 1; j < arr.length; j++) {
				arr[j] = 0;
			}
		}
		basic.BasicTest.printArray(arr);
	}

	private static List<String> process(int n) {
		List<String> res = new ArrayList<>();
		char[] arr = new char[n];
		Arrays.fill(arr, '0');
		String text;
		while ((text = genNext(arr)) != null) {
			res.add(text);
		}
		return res;
	}

	private static String genNext(char[] arr) {
		int i = arr.length - 1;
		while (i >= 0 && arr[i] == '1') {
			i--;
		}
		if (i >= 0) {
			arr[i] = '1';
			for (int j = i + 1; j < arr.length; j++) {
				arr[j] = '0';
			}
			return new String(arr);
		} else {
			return null;
		}
	}
}
