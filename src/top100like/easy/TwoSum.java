/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.BasicTest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HieuDucNguyen
 */
public class TwoSum {

    public static int[] process(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int findingNum = target - arr[i];
            for (int j = (i + 1); j < arr.length; j++) {
                if (arr[j] == findingNum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] process2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int findingNum = target - arr[i];
            Integer index = map.get(findingNum);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    public static int[] process3(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-10,-1,-18,-19};
        int[] ret = process3(arr, -19);
        BasicTest.printArrayInt(ret);
    }
}
