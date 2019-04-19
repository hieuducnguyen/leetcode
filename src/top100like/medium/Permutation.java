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
                List<List<Integer>> tmpList = new ArrayList<>();
                for (List<Integer> list : lists) {
                    for (int i = 0; i < arr.length; i++) {
                        if (!list.contains(arr[i])) {
                            List<Integer> newList = new ArrayList<>(list);
                            newList.add(arr[i]);
                            tmpList.add(newList);
                        }
                    }
                }
                lists = new ArrayList<>(tmpList);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        List<List<Integer>> list = process(arr);
        list.forEach((line) -> {
            System.out.println(line);
        });
        System.out.println("list: " + list.size());
    }
}
