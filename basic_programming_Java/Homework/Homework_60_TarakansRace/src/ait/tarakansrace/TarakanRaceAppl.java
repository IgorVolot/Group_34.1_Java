package ait.tarakansrace;

import ait.tarakansrace.model.TarakansRaceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*
    Создать приложение-игру «TarakansRace» Таракан - поток, выполняющий цикл итераций.
    На каждой итерации поток выводит свой собственный номер и переходит в режим сна на случайное количество миллисекунд [2-5].
    Диапазон времени сна должен быть одинаковым для всех тараканов. Таракан, закончивший круг первым, считается победителем.

    Приложение должно принимать количество тараканов и расстояние (колличество итераций) из консольного ввода/вывода.
    В конце игры должно быть распечатано следующее сообщение “Congratulations to tarakan #X (winner)” где Х - номер таракана-победителя.
     */
public class TarakanRaceAppl {
    static Scanner scanner = new Scanner(System.in);
    private static int NUMBER; // number of race participants
    private static int ROUNDS; // number of iterations (race circles)
    public static String winnerName;

    public static void main(String[] args) {
//        System.out.println("PLease, enter the number of participants in race");
//        NUMBER = scanner.nextInt();
//        System.out.println("Please, enter the number of race circles");
//        ROUNDS = scanner.nextInt();

        try (BufferedReader br = new BufferedReader(new FileReader("race"))) {
            String str = br.readLine();
            String[] cells = str.split(",");
            while (str != null) {
                NUMBER = Integer.parseInt(cells[0]);
                ROUNDS = Integer.parseInt(cells[1]);
                str = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int randomTime = (int) (Math.random() * (5 - 2 + 1) + 2);
        System.out.println("Race started");
        TarakansRaceImpl tarakansRace = new TarakansRaceImpl("" + NUMBER, ROUNDS);
        Thread thread = new Thread(tarakansRace);

        TarakansRaceImpl[] raceParticip = new TarakansRaceImpl[NUMBER];
        for (int i = 0; i < raceParticip.length; i++) {
            raceParticip[i] = new TarakansRaceImpl("" + i, ROUNDS);
        }
        Thread[] threads = new Thread[NUMBER];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(raceParticip[i]);
        }

        thread.start();

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Tarakan# " + NUMBER + ", round = " + i);
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (winnerName == null) {
            winnerName = tarakansRace.getName();
        }

        System.out.println("Congratulations to the owner of tarakan# " + winnerName);
        System.out.println("Race finished");
    }
}
