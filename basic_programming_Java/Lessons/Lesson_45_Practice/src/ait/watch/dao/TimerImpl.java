package ait.watch.dao;

import ait.watch.dao.Timer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class TimerImpl implements Timer {
    @Override
    public void startTimer(long sec) {
        LocalTime now = LocalTime.now();
        LocalTime endTime = now.plusSeconds(sec);

        System.out.println("Starts at: " + now);

        while (!now.isAfter(endTime)) {
            now = LocalTime.now();
//            System.out.println("Current time: " + now);
            System.out.println("Seconds left: " + sec--);
            sleep(1000);
        }
        System.out.println("End: " + now);
    }

    @Override
    public long stopWatch(Scanner scanner) {
        System.out.println("Push enter to start stopwatch");
        scanner.nextLine();
        long startTime = System.currentTimeMillis();

        System.out.println("Push enter to stop stopwatch");
        scanner.nextLine();
        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000;
    }

    @Override
    public LocalTime stopWatchInTime(Scanner scanner) {
        System.out.println("Push enter to start stopwatch");
        scanner.nextLine();
        LocalTime startTime = LocalTime.now();

        System.out.println("Push enter to end stopwatch");
        scanner.nextLine();
        LocalTime endTime = LocalTime.now();

//        LocalTime different = endTime
//                .minusHours(startTime.getHour())
//                .minusMinutes(startTime.getMinute())
//                .minusSeconds(startTime.getSecond())
//                .minusNanos(startTime.getNano());
//
//        return different;

        return endTime
                .minusHours(startTime.getHour())
                .minusMinutes(startTime.getMinute())
                .minusSeconds(startTime.getSecond())
                .minusNanos(startTime.getNano());
    }


    @Override
    public void alarm(LocalDateTime timeToWakeUp) {
        while (LocalDateTime.now().compareTo(timeToWakeUp) < 0) {
            sleep(1000);
        }

//        while (LocalDateTime.now().isBefore(timeToWakeUp)){  или так
//            sleep(1000);
//        }
        System.out.println("Time to wake up, now is: " + LocalDateTime.now());
    }

    @Override
    public void pomodoroTimer(Scanner scanner) {
        System.out.println("Push enter to start");
        scanner.nextLine();

        String stop = scanner.nextLine();
        String[] schedule = {"work", "short brake", "work", "short brake", "work", "long brake"};
        while (!stop.equals(scanner.nextLine())) {
            LocalTime startTime = LocalTime.now();
            for (int i = 0; i < schedule.length; i++) {
                if (schedule[i].equals("work")){
                    System.out.println("Work next 25 minutes");
                    LocalTime timeToWork = startTime.plusSeconds(25);
                }
                if (schedule[i].equals("short brake")){
                    System.out.println("Have a brake 5 minutes");
                    LocalTime brakeTime = startTime.plusSeconds(5);
                }
                if (schedule[i].equals("long brake")){
                    LocalTime brakeTime = startTime.plusSeconds(15);
                    System.out.println("Have a brake 15 minutes");
                }
            }
        }
        System.out.println("Push enter to stop");
    }


    public static void sleep(long sleepDurationInMs) {
        try {
            Thread.sleep(sleepDurationInMs);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
