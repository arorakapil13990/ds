package linkedList;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Test {
        public static void main(String[] args) {
            List<Integer> list = new CopyOnWriteArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);

            for(Integer i : list){
                list.add(5);
                System.out.println(i);
            }
        }
    }
