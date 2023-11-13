package ait.list;

import ait.list.interfaces.IList;
import ait.list.model.MyArrayList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ListAppl {
    public ListAppl() {
    }

    public static void main(String[] args) {
        IList<Integer> list = new MyArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(7);
        list.add(null);
        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println(list.get(5));

        System.out.println("------ indexOf -------");
        System.out.println(list.indexOf(3));
        System.out.println(list.indexOf(7));
        System.out.println(list.indexOf(null));
        System.out.println(list.indexOf(10));
        System.out.println("Size of List = " + list.size());
        Integer num = list.remove(5);
        System.out.println(num);
        System.out.println(list.size());
        System.out.println(list.remove((Integer) 7));
        System.out.println(list.size());
        System.out.println("Size of List = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            System.out.print(curr + " | ");
        }

        System.out.println();
        System.out.println("============= Homework ==============");

        System.out.println("------- Clear ---------");
        list.clear();
        System.out.println("Size of List = " + list.size());

        list.add(2);
        list.add(7);
        list.add(5);
        list.add(1);
        list.add(0);
        list.add(5);
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            System.out.print(curr + " | ");
        }
        System.out.println();
        System.out.println("Size of List = " + list.size());
        System.out.println("------- Add (index, element) ---------");

        num = 25;
        System.out.println(list.add( 3, num));
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            System.out.print(curr + " | ");
        }
        System.out.println();
        System.out.println("Size of List = " + list.size());

        System.out.println("------ lastIndexOf -------");
        num = 5;
        list.add(5);
        System.out.println("Index of last " + num + " = " + list.lastIndexOf(num));
        System.out.println("Size of List = " + list.size());
        
        System.out.println("------- set ---------");
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            System.out.print(curr + " | ");
        }
        System.out.println();

        num = 12;
        System.out.println("Replaced element is: " + list.set(4, num));
        System.out.println("Size of List = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            System.out.print(curr + " | ");
        }

        System.out.println();
        System.out.println("------- Iterator ---------");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println("------- Clear ---------");
        list.clear();
        System.out.println("Size of List = " + list.size());

    }
}
