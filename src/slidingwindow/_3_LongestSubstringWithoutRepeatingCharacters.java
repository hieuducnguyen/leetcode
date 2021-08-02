package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 12/07/2021
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
	public static final _3_LongestSubstringWithoutRepeatingCharacters INSTANCE =
		new _3_LongestSubstringWithoutRepeatingCharacters();

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int begin = 0, end = 0, counter = 0, d = 0;

		while (end < s.length()) {
			// > 0 means repeating character
			//if(map[s.charAt(end++)]-- > 0) counter++;
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) > 1)
				counter++;
			end++;

			while (counter > 0) {
				//if (map[s.charAt(begin++)]-- > 1) counter--;
				char charTemp = s.charAt(begin);
				if (map.get(charTemp) > 1)
					counter--;
				map.put(charTemp, map.get(charTemp) - 1);
				begin++;
			}
			d = Math.max(d, end - begin);
		}
		return d;
	}


	public int lengthOfLongestSubstring1(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		final HashMap<Character, Integer> map = new HashMap<>();
		int startWindow = 0, endWindow = 0, longestSubString = 0;
		final char[] array = s.toCharArray();
		while (endWindow < array.length) {
			Integer orDefault = map.getOrDefault(array[endWindow], 0);
			map.put(array[endWindow], ++orDefault);
			while (map.getOrDefault(array[endWindow], 0) > 1) {
				Integer frequenceStartWindow = map.getOrDefault(array[startWindow], 0);
				map.put(array[startWindow], --frequenceStartWindow);
				startWindow++;
			}
			longestSubString = Math.max(longestSubString, endWindow - startWindow + 1);
			endWindow++;
		}
		return longestSubString;
	}
}
