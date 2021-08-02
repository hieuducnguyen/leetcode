package top100inteview.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 10/07/2021
 */
public class _191_Numberof1Bits {
	public static final _191_Numberof1Bits INSTANCE = new _191_Numberof1Bits();


	public int hammingWeight1(int n) {
		Map<Integer, Integer> mapBit = new HashMap<>();
		mapBit.put(0, 0);
		mapBit.put(1, 1);
		mapBit.put(2, 1);
		mapBit.put(3, 2);
		mapBit.put(4, 1);
		mapBit.put(5, 2);
		mapBit.put(6, 2);
		mapBit.put(7, 3);
		mapBit.put(8, 1);
		mapBit.put(9, 2);
		mapBit.put(10, 2);
		mapBit.put(11, 3);
		mapBit.put(12, 2);
		mapBit.put(13, 3);
		mapBit.put(14, 3);
		mapBit.put(15, 4);
		int mask = 0xF;
		int result = 0;
		for (int i = 0; i < 8; i++) {
			int k = n & mask;
			final Integer numBit1 = mapBit.get(k);
			n >>= 4;
			result += numBit1;
		}
		return result;
	}

	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n = n & (n - 1);
		}
		return sum;
	}
}
