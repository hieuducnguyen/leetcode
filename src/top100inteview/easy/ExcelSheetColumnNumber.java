/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

/**
 *
 * @author hieund3
 */
public class ExcelSheetColumnNumber {

	public static ExcelSheetColumnNumber INSTANCE = new ExcelSheetColumnNumber();

	public static void main(String[] args) {
		String s = "";
		int num = INSTANCE.titleToNumber(s);
		System.out.println("num: " + num);
	}

	public int titleToNumber(String s) {
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			int tmpValue = s.charAt(i) - 'A' + 1;
			value = value * 26 + tmpValue;
		}
		return value;
	}
}
