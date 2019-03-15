/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class LIS {

    public static int process(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        class Item {

            Item(int val, int increase) {
                this.val = val;
                this.increase = increase;
            }
            int val;
            int increase;
        }
        List<Item> list = new ArrayList<>();
        int longest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int len = 0;
            for (int j = 0; j < list.size(); j++) {
                if (array[i] > list.get(j).val) {
                    if (len < list.get(j).increase) {
                        len = list.get(j).increase;
                    }
                }
            }
            len++;
            Item item = new Item(array[i], len);
            list.add(item);
            if (longest < len) {
                longest = len;
            }
        }
        return longest;
    }

    public static int process2(int[] array) {
        int[] dp = new int[array.length];
        int len = 0;
        for (int num : array) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
//		int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int len = process2(arr);
        System.out.println("len: " + len);
    }
}
