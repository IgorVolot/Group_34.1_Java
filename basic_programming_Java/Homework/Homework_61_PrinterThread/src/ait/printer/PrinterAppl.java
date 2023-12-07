package ait.printer;

import ait.printer.task.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrinterAppl {
    static int numberOfStingsToPrint; // total number of digits to print (number of strings)
    static int numberOfPortion; // quantity of portion in Printer threads (digits count from 1 to numberOfPortion)
    static int numsInRow; // number of Printer threads (number of digits in row)
    static int minutes; // clock period (in minutes period)

    public static void main(String[] args) throws IOException {

        Printer printThread = new Printer(numsInRow);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter time in minutes for thread sleep (e.g. 30 min)");
        printThread.setClockPeriod(minutes = Integer.parseInt(br.readLine()));

        System.out.println("Enter the number of digits (Printer threads (e.g. 5))");
        printThread.setNumber(numsInRow = Integer.parseInt(br.readLine()));

        System.out.println("Enter total quantity to print (e.g. 100)");
        numberOfStingsToPrint = Integer.parseInt(br.readLine());

        System.out.println("Enter the quantity of portion in Printer threads (e.g. 10)");
        numberOfPortion = Integer.parseInt(br.readLine());

        Thread[] print = threadToPrint(numsInRow);
        nextThreadToPrint(print);
    }

    private static void nextThreadToPrint(Thread[] print) {
        int counter = 0;
        while (counter != numberOfStingsToPrint / numsInRow) {
            for (int i = 0; i < print.length; i++) {
                print[i].interrupt();
                printDigits(i);
            }
            counter++;
        }
    }

    private static void printDigits(int digit) {
        for (int i = 0; i < numsInRow; i++) {
            System.out.print(digit + 1);
        }
        System.out.println();
    }

    private static Thread[] threadToPrint(int numsInRow) {
        Thread[] threads = new Thread[numsInRow];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Printer(numsInRow));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        return threads;
    }
}
