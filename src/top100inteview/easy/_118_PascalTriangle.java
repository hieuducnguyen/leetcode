package top100inteview.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by hieund3 on 05/07/2021
 */
public class _118_PascalTriangle {
	public static final _118_PascalTriangle INSTANCE = new _118_PascalTriangle();

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		final List<Integer> list = new ArrayList<>();
		list.add(1);
		result.add(list);
		if (numRows == 1) {
			return result;
		}
		final List<Integer> secondList = new ArrayList<>();
		secondList.add(1);
		secondList.add(1);
		result.add(secondList);
		if (numRows == 2) {
			return result;
		}
		for (int i = 2; i < numRows; i++) {
			final List<Integer> integers = new ArrayList<>();
			integers.add(1);
			for (int j = 1; j < i; j++) {
				integers.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
			}
			integers.add(1);
			result.add(integers);
		}
		return result;
	}
}
