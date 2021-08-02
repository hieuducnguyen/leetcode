package datastream;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by hieund3 on 11/07/2021
 */
public class FindMedianFromDataStream {
	public static final FindMedianFromDataStream INSTANCE = new FindMedianFromDataStream();

	/**
	 * initialize your data structure here.
	 */
	int size = 0, middle1 = 0, middle2 = 0;
	List<Integer> list = new ArrayList<>();

	public FindMedianFromDataStream() {

	}

	public void addNum(int num) {
		list.add(num);
		if (size % 2 == 0) {

		}
	}

	public double findMedian() {
//		if (size % 2 == 0) {
//			return
//		}
		return 0;
	}
}
