package ait.tarakansrace;

import ait.tarakansrace.model.TarakansRaceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/*
    Создать приложение-игру «TarakansRace» Таракан - поток, выполняющий цикл итераций.
    На каждой итерации поток выводит свой собственный номер и переходит в режим сна на случайное количество миллисекунд [2-5].
    Диапазон времени сна должен быть одинаковым для всех тараканов. Таракан, закончивший круг первым, считается победителем.

    Приложение должно принимать количество тараканов и расстояние (колличество итераций) из консольного ввода/вывода.
    В конце игры должно быть распечатано следующее сообщение “Congratulations to tarakan #X (winner)” где Х - номер таракана-победителя.
     */
public class TarakanRaceAppl {
    private static int NUMBER; // number of race participants
    private static int ROUNDS; // number of iterations (race circles)
    public static String winnerName;

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("race"))) {
            String str = br.readLine();
            String[] cells = str.split(",");
            NUMBER = Integer.parseInt(cells[0]);
            ROUNDS = Integer.parseInt(cells[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Race started");

        TarakansRaceImpl[] raceParticip = new TarakansRaceImpl[NUMBER];
        for (int i = 0; i < raceParticip.length; i++) {
            raceParticip[i] = new TarakansRaceImpl("" + (i + 1));
        }
        Thread[] threads = new Thread[NUMBER];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(raceParticip[i]);
        }


        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Congratulations to the owner of tarakan# " + winnerName);
        System.out.println("Race finished");
    }
}
