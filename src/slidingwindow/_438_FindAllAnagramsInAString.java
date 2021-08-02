package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by hieund3 on 11/07/2021
 */
public class _438_FindAllAnagramsInAString {
	public static final _438_FindAllAnagramsInAString INSTANCE = new _438_FindAllAnagramsInAString();

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length()) {
			return result;
		}
		Map<Character, Integer> frequence = new HashMap<>();
		for (char c : p.toCharArray()) {
			frequence.merge(c, 1, Integer::sum);
		}
		int startWindow = 0, endWindow = 0, counter = frequence.size();
		while (endWindow < s.length()) {
			if (frequence.containsKey(s.charAt(endWindow))) {
				frequence.put(s.charAt(endWindow), frequence.get(s.charAt(endWindow)) - 1);
				if (frequence.get(s.charAt(endWindow)) == 0) {
					counter--;
				}
			}
			while (counter == 0) {
				if (endWindow - startWindow + 1 == p.length()) {
					result.add(startWindow);
				}
				if (frequence.containsKey(s.charAt(startWindow))) {
					frequence.put(s.charAt(startWindow), frequence.get(s.charAt(startWindow)) + 1);
					if (frequence.get(s.charAt(startWindow)) > 0) {
						counter++;
					}
				}
				startWindow++;
			}
			endWindow++;
		}
		return result;
	}


	public List<Integer> findAnagrams3(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] target = new int[26];
		final char[] targetCharArr = p.toCharArray();
		for (char c : targetCharArr) {
			target[c - 'a']++;
		}
		final char[] array = s.toCharArray();
		int[] temp = new int[26];
		int startWindow = 0, endWindow = 0;
		while (endWindow < array.length) {
			temp[array[endWindow] - 'a']++;
			while (temp[array[endWindow] - 'a'] > target[array[endWindow] - 'a']) {
				temp[array[startWindow] - 'a']--;
				startWindow++;
			}
			if (temp[array[endWindow] - 'a'] == target[array[endWindow] - 'a'] && endWindow - startWindow + 1 == p.length()) {
				result.add(startWindow);
			}
			endWindow++;
		}
		return result;
	}

	public List<Integer> findAnagrams2(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int target = 0;
		final char[] targetArray = p.toCharArray();
		for (int i = 0; i < targetArray.length; i++) {
			target += (targetArray[i] - 'a');
		}
		final char[] charArray = s.toCharArray();
		int startWindow = 0, endWindow = 0, tmpValue = 0;
		while (endWindow < charArray.length) {
			tmpValue += (charArray[endWindow] - 'a');
			if (endWindow >= p.length() - 1) {
				if (tmpValue == target) {
					result.add(startWindow);
				}
				tmpValue -= (charArray[startWindow] - 'a');
				startWindow++;
			}
			endWindow++;
		}
		return result;
	}

	public List<Integer> findAnagrams1(String s, String p) {
		int[] target = new int[26];
		for (char c : p.toCharArray()) {
			target[c - 'a']++;
		}
		List<Integer> result = new ArrayList<>();
		int[] temp = new int[26];
		int startWindow = 0, endWindow = 0;
		final char[] array = s.toCharArray();
		while (endWindow < array.length) {
			temp[array[endWindow] - 'a']++;
			if (endWindow >= p.length() - 1) {
				if (anagram(temp, target)) {
					result.add(startWindow);
				}
				temp[array[startWindow] - 'a']--;
				startWindow++;
			}
			endWindow++;
		}
		return result;
	}

	private boolean anagram(int[] temp, int[] target) {
		for (int i = 0; i < temp.length; i++) {
			if (target[i] != temp[i]) {
				return false;
			}
		}
		return true;
	}
}
