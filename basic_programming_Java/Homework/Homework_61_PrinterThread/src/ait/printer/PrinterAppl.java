package ait.printer;

import ait.printer.task.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
        Напишите класс Printer thread, который печатает определенное количество его номера (например, 100) порциями.
        Каждая порция должна содержать определенное количество цифр (например, 10). Во время печати одной порции никто из других потоков не печатает.
        Вывод должен выглядеть следующим образом
        .........
        Примечание по реализации: применить синхронизацию sleep/interrupt.

        Напишите класс PrinterAppl с методом main, который настраивает и запускает определенное количество (например, 4) потоков Printer.

        Рекомендации по реализации;

        После запуска все потоки будут спать
        Основной поток прерывает первый поток.
        Первый поток печатает порцию и прерывает второй поток (он должен иметь ссылку на второй поток).
        Второй прерывает третий и так далее. Последний поток прерывает первый. Таким образом, появится цепочка потоков, которую должен задать PrinterAppl.
        Потоки завершаются после распечатки всех порций.
         */
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

        Printer[] task = new Printer[numsInRow];
        for (int i = 0; i < task.length; i++) {
            task[i] = new Printer(numsInRow);
        }

        Thread[] threadsToPrint = new Thread[numsInRow];
        for (int i = 0; i < threadsToPrint.length; i++) {
            threadsToPrint[i] = new Thread(task[i]);
        }
        for (int i = 0; i < threadsToPrint.length; i++) {
            threadsToPrint[i].start();

        }
        for (int i = 0, n = 0; n < numberOfStingsToPrint + 1; n++) {
            int counter = 0;
            if (i != numsInRow){
                threadsToPrint[i].interrupt();
                for (int j = 0; j < numberOfPortion; j++) {
                    System.out.print(i + 1);
                }
                System.out.println();
                Thread nextThread = threadsToPrint[counter + 1];
                printThread.setNextThread(nextThread);
                i ++;
            } else {
                i = 0;
            }
        }
    }
}
