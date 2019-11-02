/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class PascalTriangle {

	static final PascalTriangle INSTANCE = new PascalTriangle();

	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> result = INSTANCE.generate(numRows);
		System.out.println(result);
	}

	private List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) {
			return result;
		}
		result.add(Arrays.asList(1));
		if (numRows == 1) {
			return result;
		}
		for (int i = 2; i <= numRows; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (j == 0 || j == i - 1) {
					list.add(1);
				} else {
					final Integer value1 = result.get(i - 2).get(j - 1);
					final Integer value2 = result.get(i - 2).get(j);
					list.add(value1 + value2);
				}
			}
			result.add(list);
		}
		return result;
	}
}
