package ait.mystring;

import ait.mystring.model.MyString;

import java.util.Iterator;

public class MyStringAppl {
    public static void main(String[] args) {
        MyString myStr = new MyString("Two beer, or not two beer");
        System.out.println(myStr);

        myStr.addChar('!');
        System.out.println(myStr);

        myStr.removeChar(',');
        System.out.println(myStr);

        System.out.println("=======================================");
        Iterator<Character> iterator = myStr.iterator();
        while (iterator.hasNext()){
            char c = iterator.next();
            if (c == 'e' || c == 'o'){
                iterator.remove();
            }
        }
        System.out.println(myStr);

//        for (char c: myStr) {
//            System.out.println(Character.toUpperCase(c));
//        }

        /*
        Wrong Way!!!
        for (char c : myStr) {
            if (c == 'r'){
                myStr.removeChar(c);
            }
        }
        System.out.println(myStr);

         */




//        Iterator<Character> iterator = myStr.iterator();
//        while (iterator.hasNext()){
//            char c = iterator.next();
//            System.out.println(Character.toUpperCase(c));
//        }
//
//        System.out.println("=======================================");
//        iterator = myStr.iterator();
//        while (iterator.hasNext()){
//            char c = iterator.next();
//            System.out.println(Character.toLowerCase(c));
//        }

//        StringBuilder builder = myStr.getStr();
//        for (int i = 0; i < builder.length(); i++) {
//            char c = builder.charAt(i);
//            System.out.println(Character.toUpperCase(c));
//        }
//
//        builder.setLength(3);
//        System.out.println(builder);
//        System.out.println(myStr);

    }
}
