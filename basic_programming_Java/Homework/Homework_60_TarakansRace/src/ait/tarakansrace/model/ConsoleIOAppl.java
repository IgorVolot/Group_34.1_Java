package ait.tarakansrace.model;

import java.io.*;

public class ConsoleIOAppl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name: ");
        String str = br.readLine();

        PrintWriter pw = new PrintWriter(new FileWriter(str, true));
        System.out.println("PLease, enter the number of participants in the race and number of circles with ',' as delimiter.");
        str = br.readLine();
        pw.print(str);
        pw.close();
    }
}
