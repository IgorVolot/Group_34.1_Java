package ait.watch;

import ait.watch.dao.Timer;
import ait.watch.dao.TimerImpl;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Timer time = new TimerImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set timer in seconds");
        int timerTime = scanner.nextInt();

        time.startTimer(timerTime);

        System.out.println("========  Stopwatch  =============");

        long stopWatchResult = time.stopWatch(scanner);
        System.out.println(stopWatchResult);

        System.out.println("========  AlarmWatch  =============");

        System.out.println("Enter year");
        int year = scanner.nextInt();
        System.out.println("Enter month");
        int month = scanner.nextInt();
        System.out.println("Enter day");
        int day = scanner.nextInt();
        System.out.println("Enter hour");
        int hour = scanner.nextInt();
        System.out.println("Enter minutes");
        int min = scanner.nextInt();

        LocalDateTime timeToWakeUp = LocalDateTime.of(year, month, day, hour, min);
        time.alarm(timeToWakeUp);

        System.out.println("========  Pomodoro Technique  =============");

        time.pomodoroTimer(scanner);


    }
}
