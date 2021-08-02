package top100inteview.easy;

/*
 * Created by hieund3 on 09/07/2021
 */
public class _171_ExcelSheetColumnNumber {
	public static final _171_ExcelSheetColumnNumber INSTANCE = new _171_ExcelSheetColumnNumber();

	public int titleToNumber(String columnTitle) {
		final char[] array = columnTitle.toCharArray();
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			int num = (array[i] - 'A' + 1) * (int) Math.pow(26, array.length - 1 - i);
			sum += num;
		}
		return sum;
	}
}
