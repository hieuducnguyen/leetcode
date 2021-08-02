package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 17/07/2021
 */
public class _1358_NumberofSubstringsContainingAllThreeCharacters {
	public static final _1358_NumberofSubstringsContainingAllThreeCharacters INSTANCE =
		new _1358_NumberofSubstringsContainingAllThreeCharacters();

	public int numberOfSubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> frequence = new HashMap<>();
		frequence.put('a', 0);
		frequence.put('b', 0);
		frequence.put('c', 0);
		int startWindow = 0, endWindow = 0, numSubString = 0, counter = 3;
		while (endWindow < s.length()) {
			if (frequence.containsKey(s.charAt(endWindow))) {
				frequence.merge(s.charAt(endWindow), 1, Integer::sum);
				if (frequence.get(s.charAt(endWindow)) == 1) {
					counter--;
				}
			}
			while (counter == 0) {
				if (frequence.containsKey(s.charAt(startWindow))) {
					frequence.put(s.charAt(startWindow), frequence.get(s.charAt(startWindow)) - 1);
					if (frequence.get(s.charAt(startWindow)) == 0) {
						counter++;
					}
				}
				startWindow++;
			}
			numSubString += startWindow;
			endWindow++;
		}
		return numSubString;
	}
}
