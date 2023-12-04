package ait.charstream;

import java.io.*;

public class ConsoleIOAppl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name: ");
        String str = br.readLine();

        PrintWriter pw = new PrintWriter(new FileWriter(str, true));
        System.out.println("Please, write your text here: ");
        str = br.readLine();
        while (!"exit".equalsIgnoreCase(str)){
            pw.println(str);
            pw.flush();
            System.out.println("Please, write your text here: ");
            str = br.readLine();
        }
        pw.close();
//        pw.flush();
    }
}
