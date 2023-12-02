package ait.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

        /*
        В классе CompareAppl реализовать логику сравнения двух файлов в методе main. Имена файлов принимать через массив args.
        Два файла считаем одинаковыми, если у них одинаковая длина, и на тех же позициях стоят те же байты.
        Результат должен быть выведен на консоль в виде сообщения.
         */

public class CompareAppl {
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Wrong number of arguments");
            return;
        }
        System.out.println("Source: " + args[0]);
        System.out.println("Source: " + args[1]);
        System.out.println("Source: " + args[2]);
        System.out.println("Source: " + args[3]);
        System.out.println("Source: " + args[4]);
        System.out.println("Source: " + args[5]);

        try (FileInputStream fin1 = new FileInputStream(args[0]); FileInputStream fin2 = new FileInputStream(args[1]);
             FileInputStream fin3 = new FileInputStream(args[2]); FileInputStream fin4 = new FileInputStream(args[3]);
             FileInputStream fin5 = new FileInputStream(args[4]); FileInputStream fin6 = new FileInputStream(args[5])) {
            int len1 = fin1.available();
            byte[] arr1 = new byte[len1];

            int len2 = fin2.available();
            byte[] arr2 = new byte[len2];

            int len3 = fin3.available();
            byte[] arr3 = new byte[len3];

            int len4 = fin4.available();
            byte[] arr4 = new byte[len4];

            int len5 = fin5.available();
            byte[] arr5 = new byte[len5];

            int len6 = fin6.available();
            byte[] arr6 = new byte[len6];
            if (len3 == len4 && Arrays.equals(arr3, arr4)) {
                System.out.println("File <" + args[2] + "> and file <" + args[3] + "> are equal.");
            } else {
                System.out.println("Files are NOT equal.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
