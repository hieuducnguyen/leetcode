/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author hieund3
 */
public class Sum4II {

	public static void main(String[] args) {
		int[] A = new int[]{1, 1};
		int[] B = new int[]{1, -1};
		int[] C = new int[]{-1, 1};
		int[] D = new int[]{-1, 1};
		int count = fourSumCount(A, B, C, D);
		System.out.println(count);
	}

	private static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> newMap = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			map.merge(A[i], 1, (t, v) -> {
				return v + t;
			});
		}
		newMap.clear();
		for (int i = 0; i < B.length; i++) {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				newMap.merge(entry.getKey() + B[i], entry.getValue(), (t, v) -> {
					return t + v;
				});
			}
		}
		map.clear();
		map.putAll(newMap);

		newMap.clear();
		for (int i = 0; i < C.length; i++) {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				newMap.merge(entry.getKey() + C[i], entry.getValue(), (t, v) -> {
					return t + v;
				});
			}
		}
		map.clear();
		map.putAll(newMap);

		int result = 0;
		for (int i = 0; i < D.length; i++) {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getKey() + D[i] == 0) {
					result += entry.getValue();
				}
			}
		}
		return result;
	}

	private static int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				map.merge(A[i] + B[j], 1, (t, v) -> {
					return t + v;
				});
			}
		}
		int result = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				result += map.getOrDefault(-(C[i] + D[j]), 0);
			}
		}
		return result;
	}
}
