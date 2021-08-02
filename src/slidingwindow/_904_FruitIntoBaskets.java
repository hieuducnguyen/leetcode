package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 18/07/2021
 */
public class _904_FruitIntoBaskets {
	public static final _904_FruitIntoBaskets INSTANCE = new _904_FruitIntoBaskets();

	public int totalFruit(int[] fruits) {
		if (fruits == null || fruits.length == 0) {
			return 0;
		}
		Map<Integer, Integer> frequence = new HashMap<>();
		int startWindow = 0, endWindow = 0, maxLen = Integer.MIN_VALUE, counter = 2;
		while (endWindow < fruits.length) {
			frequence.put(fruits[endWindow], frequence.getOrDefault(fruits[endWindow], 0) + 1);
			if (frequence.get(fruits[endWindow]) == 1) {
				counter--;
			}
			while (counter < 0) {
				frequence.put(fruits[startWindow], frequence.get(fruits[startWindow]) - 1);
				if (frequence.get(fruits[startWindow]) == 0) {
					counter++;
				}
				startWindow++;
			}
			if (counter == 0) {
				maxLen = Math.max(maxLen, endWindow - startWindow + 1);
			}
			endWindow++;
		}
		return maxLen == Integer.MIN_VALUE ? fruits.length : maxLen;
	}
}
