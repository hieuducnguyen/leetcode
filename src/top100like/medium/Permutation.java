/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class Permutation {

    // note dùng queue hay vì list of list, dk dừng là queue đó có size bằng 7 (arr.length)
    public static List<List<Integer>> lists = new ArrayList<>();

    private static List<List<Integer>> process(int[] arr) {
        int len = arr.length;
        while (lists.isEmpty() || lists.get(0).size() < len) {
            if (lists.isEmpty()) {
                for (int i = 0; i < arr.length; i++) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    lists.add(list);
                }
            } else {
                for (List<Integer> list : lists) {
                    for (int i = 0; i < arr.length; i++) {
                        if (!list.contains(arr[i])) {
                            List<Integer> newList = new ArrayList<Integer>(list);
                            newList.add(arr[i]);
                            lists.add(newList);
                        }
                    }
                    lists.remove(list);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
//		int[] arr = new int[]{1, 2};
//		List<List<Integer>> listOfList = process(arr);
//		for (int i = 0; i < listOfList.size(); i++) {
//			System.out.println("list: " + listOfList.get(i));
//		}
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        lists.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(8);
        list2.add(8);
        lists.add(list2);

        int i = 0;
        for (List list : lists) {
            System.out.println("test " + list);
            lists.add(list1);
        }
        System.out.println("list" + lists);
    }
}
