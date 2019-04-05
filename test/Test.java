
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HieuDucNguyen
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println("list " + list);
    }
}
