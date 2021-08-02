package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by hieund3 on 13/07/2021
 */
public class _30_SubstringWithConcatenationOfAllWords {
	public static final _30_SubstringWithConcatenationOfAllWords INSTANCE =
		new _30_SubstringWithConcatenationOfAllWords();

	public List<Integer> findSubstring(String s, String[] words) {
		Map<String, Integer> frequence = new HashMap<>();
		int len = 0;
		for (String word : words) {
			len += word.length();
			frequence.merge(word, 1, Integer::sum);
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < (s.length() - len + 1); i++) {
			boolean concat = checkConcat(s.substring(i, i + len), frequence, words[0].length());
			if (concat) {
				result.add(i);
			}
		}
		return result;
	}

	private boolean checkConcat(String substring, Map<String, Integer> frequence, int len) {
		Map<String, Integer> value = new HashMap<>();
		for (int i = 0; i < substring.length(); i += len) {
			final String substring1 = substring.substring(i, i + len);
			value.merge(substring1, 1, Integer::sum);
		}
		return frequence.equals(value);
	}

}
