/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

/**
 *
 * @author hieund3
 */
public class DecodeWays {

	public static final DecodeWays Instance = new DecodeWays();

	public static void main(String[] args) {
		String s = "12120";
		int nums = Instance.numDecodings(s);
		System.out.println("nums: " + nums);
	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.startsWith("0")) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		char[] chars = s.toCharArray();
		int numDecodings = 1;
		int[] decodeArr = new int[chars.length];
		decodeArr[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			if (chars[i] == '0' && !isNumber(chars[i], chars[i - 1])) {
				return 0;
			}
			if (chars[i] != '0' && isNumber(chars[i], chars[i - 1])) {
				numDecodings = i == 1 ? 2 : (decodeArr[i - 2] + decodeArr[i - 1]);
			} else if (chars[i] == '0' && i >= 2 && isNumber(chars[i - 1], chars[i - 2])) {
				if (i == 2) {
					numDecodings--;
				} else {
					numDecodings -= decodeArr[i - 3];
				}
			}
			decodeArr[i] = numDecodings;
		}
		return numDecodings;
	}

	private boolean isNumber(char presentChar, char previousChar) {
		return (((presentChar == '0' || presentChar == '1' || presentChar == '2' || presentChar == '3'
			|| presentChar == '4' || presentChar == '5' || presentChar == '6')
			&& previousChar == '2') || previousChar == '1');
	}
}
