/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HieuDucNguyen
 */
public class ClimbingStairs {

	public static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int num = 45;
		int numWay = process1(num);
		System.out.println("numWay: " + numWay);
	}

	private static int process(int num) {
		if (num <= 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		if (num == 2) {
			return 2;
		}
		if (map.containsKey(num)) {
			return map.get(num);
		}
		int f_1, f_2;
		if (!map.containsKey(num - 1)) {
			f_1 = process(num - 1);
			map.put(num - 1, f_1);
		} else {
			f_1 = map.get(num - 1);
		}
		if (!map.containsKey(num - 2)) {
			f_2 = process(num - 2);
			map.put(num - 2, f_2);
		} else {
			f_2 = map.get(num - 2);
		}

		return f_1 + f_2;
	}

	private static int process1(int num) {
		int[] result = new int[num];
		if (num == 1) {
			return 1;
		}
		if (num == 2) {
			return 2;
		}
		result[0] = 1;
		result[1] = 2;
		for (int i = 2; i < num; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[num - 1];
	}
}
