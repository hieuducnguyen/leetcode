package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 12/07/2021
 */
public class _76_MinimumWindowSubstring {
	public static final _76_MinimumWindowSubstring INSTANCE = new _76_MinimumWindowSubstring();

	public String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		final char[] targetArr = t.toCharArray();
		Map<Character, Integer> frequence = new HashMap<>();
		for (char c : targetArr) {
			frequence.merge(c, 1, Integer::sum);
		}
		int startWindow = 0, endWindow = 0, len = Integer.MAX_VALUE, counter = frequence.size(), head = 0;
		while (endWindow < s.length()) {
			if (frequence.get(s.charAt(endWindow)) != null) {
				frequence.put(s.charAt(endWindow), frequence.get(s.charAt(endWindow)) - 1);
				if (frequence.get(s.charAt(endWindow)) == 0) {
					counter--;
				}
			}
			while (counter == 0) {
				if (len > (endWindow - startWindow + 1)) {
					len = (endWindow - startWindow + 1);
					head = startWindow;
				}
				if (frequence.get(s.charAt(startWindow)) != null) {
					frequence.put(s.charAt(startWindow), frequence.get(s.charAt(startWindow)) + 1);
					if (frequence.get(s.charAt(startWindow)) > 0) {
						counter++;
					}
				}
				startWindow++;
			}
			endWindow++;
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
	}

	public String minWindow1(String s, String t) {
		final char[] includedCharArr = t.toCharArray();
		int[] includedArr = new int[96];
		for (int charElement : includedCharArr) {
			includedArr[charElement - ' ']++;
		}
		int[] frequenceArr = new int[96];
		final char[] array = s.toCharArray();
		int startWindow = 0, endWindow = 0;
		frequenceArr[array[endWindow] - ' ']++;
		String minSubString = null;
		while (true) {
			if (equalFrequence(frequenceArr, includedArr)) {
				if (minSubString == null || minSubString.length() > (endWindow - startWindow + 1)) {
					minSubString = s.substring(startWindow, endWindow + 1);
				}
				if (startWindow < endWindow) {
					frequenceArr[array[startWindow] - ' ']--;
					startWindow++;
				} else {
					endWindow++;
					if (endWindow >= s.length()) {
						break;
					}
					frequenceArr[array[endWindow] - ' ']++;
				}
			} else {
				endWindow++;
				if (endWindow >= s.length()) {
					break;
				}
				frequenceArr[array[endWindow] - ' ']++;
			}
		}
		return minSubString != null ? minSubString : "";
	}

	private boolean equalFrequence(int[] frequenceArr, int[] includedArr) {
		for (int i = 0; i < frequenceArr.length; i++) {
			if (includedArr[i] != 0 && frequenceArr[i] < includedArr[i]) {
				return false;
			}
		}
		return true;
	}
}
