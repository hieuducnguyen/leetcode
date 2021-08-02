package top100inteview.easy;

/*
 * Created by hieund3 on 03/07/2021
 */
public class _Removing9 {
	public static final _Removing9 INSTANCE = new _Removing9();

	int get(int n) {
		int i = 1;
		int k = 1;
		while (String.valueOf(k).contains("9") || i < n) {
			if (!String.valueOf(k).contains("9")) {
				i++;
			}
			k++;
		}
		return k;
	}
}
