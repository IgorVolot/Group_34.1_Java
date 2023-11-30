package ait.functional;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceAppl {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,9,2,8,3,7,4,6,5));

        list.sort(Integer::compare); // method reference - list.sort((n1, n2) -> Integer.compare(n1, n2));

        list.forEach(System.out::println); // method reference - list.forEach(n -> System.out.println(n));
    }

}
