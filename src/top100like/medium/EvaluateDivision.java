/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class EvaluateDivision {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		List<String> equation1 = Arrays.asList("x1", "x2");
		List<String> equation2 = Arrays.asList("x2", "x3");
		List<String> equation3 = Arrays.asList("x3", "x4");
		List<String> equation4 = Arrays.asList("x4", "x5");
		equations.add(equation1);
		equations.add(equation2);
		equations.add(equation3);
		equations.add(equation4);
		double[] values = {3.0, 4.0, 5.0, 6.0};
		List<List<String>> queries = new ArrayList<>();
		List<String> query1 = Arrays.asList("x1", "x5");
		List<String> query2 = Arrays.asList("x5", "x2");
		List<String> query3 = Arrays.asList("x2", "x4");
		List<String> query4 = Arrays.asList("x2", "x2");
		List<String> query5 = Arrays.asList("x2", "x9");
		List<String> query6 = Arrays.asList("x9", "x9");
		queries.add(query1);
		queries.add(query2);
		queries.add(query3);
		queries.add(query4);
		queries.add(query5);
		queries.add(query6);

		double[] value = process(equations, values, queries);
		basic.BasicTest.printArray(value);
		System.exit(0);
	}

	private static double[] process(List<List<String>> equations, double[] values, List<List<String>> queries) {
		if (equations == null || equations.isEmpty() || equations.size() != values.length) {
			return null;
		}
		double[] results = new double[queries.size()];
		Map<String, Double> valueMap = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String value = convert(equations.get(i));
			String valueInverse = convertInverse(equations.get(i));
			valueMap.put(value, values[i]);
			valueMap.put(valueInverse, 1 / values[i]);
		}
		Map<String, List<String>> map = new HashMap<>();
		Set<String> valueSet = new HashSet<>();
		for (List<String> subList : equations) {
			valueSet.add(subList.get(0));
			valueSet.add(subList.get(1));
			map.merge(subList.get(0), new ArrayList<>(Arrays.asList(subList.get(1))),
				(v, u) -> {
					v.add(subList.get(1));
					return v;
				});
			map.merge(subList.get(1), new ArrayList<>(Arrays.asList(subList.get(0))),
				(v, u) -> {
					v.add(subList.get(0));
					return v;
				});
		}
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			String first = query.get(0);
			String second = query.get(1);
			Set<String> set = new HashSet<>();
			double value = compute(first, second, valueMap, map, set, valueSet);
			results[i] = value;
		}
		return results;
	}

	private static String convert(List<String> equation) {
		return equation.get(0) + "/" + equation.get(1);
	}

	private static String convertInverse(List<String> equation) {
		return equation.get(1) + "/" + equation.get(0);
	}

	private static double compute(String first, String second, Map<String, Double> valueMap,
		Map<String, List<String>> map, Set<String> set, Set<String> valueSet) {
		if (first.equals(second) && valueSet.contains(first)) {
			return 1.0;
		}
		set.add(first);
		String key = first + "/" + second;
		if (valueMap.containsKey(key)) {
			return valueMap.get(key);
		}
		List<String> items = map.get(first);
		if (items != null) {
			for (int i = 0; i < items.size(); i++) {
				if (set.contains(items.get(i))) {
					continue;
				}
				double value = compute(items.get(i), second, valueMap, map, set, valueSet);
				if (value != -1) {
					double tmpValue = valueMap.get(first + "/" + items.get(i)) * value;
					return tmpValue;
				}
			}
		}
		set.remove(first);
		return -1.0;
	}
}
