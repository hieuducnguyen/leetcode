/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like;

import java.util.HashSet;

/**
 *
 * @author HieuDucNguyen
 */
public class SingleNumber {

    public static int process(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {

    }
}
