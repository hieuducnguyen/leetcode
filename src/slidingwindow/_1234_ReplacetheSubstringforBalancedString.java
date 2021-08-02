package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 17/07/2021
 */
public class _1234_ReplacetheSubstringforBalancedString {
	public static final _1234_ReplacetheSubstringforBalancedString INSTANCE =
		new _1234_ReplacetheSubstringforBalancedString();

	public int balancedString(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int average = s.length() / 4;
		char[] defaultCharArr = {'Q', 'W', 'E', 'R'};
		Map<Character, Integer> frequence = new HashMap<>();
		for (char c : s.toCharArray()) {
			frequence.merge(c, 1, Integer::sum);
		}
		for (char c : defaultCharArr) {
			if (frequence.getOrDefault(c, 0) <= average) {
				frequence.remove(c);
			} else {
				frequence.put(c, frequence.get(c) - average);
			}
		}
		if (frequence.size() == 0) {
			return 0;
		}
		int startWindow = 0, endWindow = 0, counter = frequence.size(), len = Integer.MAX_VALUE;
		while (endWindow < s.length()) {
			if (frequence.get(s.charAt(endWindow)) != null) {
				frequence.put(s.charAt(endWindow), frequence.get(s.charAt(endWindow)) - 1);
				if (frequence.get(s.charAt(endWindow)) == 0) {
					counter--;
				}
			}
			while (counter == 0) {
				len = Math.min(len, endWindow - startWindow + 1);
				if (frequence.get(s.charAt(startWindow)) != null) {
					frequence.put(s.charAt(startWindow), frequence.get(s.charAt(startWindow)) + 1);
					if (frequence.get(s.charAt(startWindow)) == 1) {
						counter++;
					}
				}
				startWindow++;
			}
			endWindow++;
		}
		return len;
	}
}
