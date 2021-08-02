package top100inteview.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 01/07/2021
 */
public class _13_Roman2Integer {
	public static final _13_Roman2Integer INSTANCE = new _13_Roman2Integer();


	public int romanToInt(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		final Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		final char[] array = s.toCharArray();
		int result = map.get(array[0]), old = map.get(array[0]);
		for (int i = 1; i < array.length; i++) {
			if (map.get(array[i]) > old) {
				result -= old * 2;
			}
			result += map.get(array[i]);
			old = map.get(array[i]);
		}
		return result;
	}

	public int romanToInt1(String s) {
		final Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		if (s == null || s.isEmpty()) {
			return 0;
		}
		final char[] array = s.toCharArray();
		int sum = map.get(array[0]);
		for (int i = 1; i < array.length; i++) {
			if (map.get(array[i]) > map.get(array[i - 1])) {
				sum = trigger(sum, array, i, map);
			}
			sum += map.get(array[i]);
		}
		return sum;
	}

	private int trigger(int sum, char[] array, int i, Map<Character, Integer> map) {
		int j = i - 1;
		while (j >= 0 && map.get(array[j]) < map.get(array[i])) {
			sum -= map.get(array[j]) * 2;
			j--;
		}
		return sum;
	}

}
