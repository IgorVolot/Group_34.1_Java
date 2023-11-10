package ait.watch;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Watch {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("========== Timer =================");
        timer();

        System.out.println("========== Seconds meter =================");
        secMeter();

        System.out.println("========== alarmWatch =================");
        alarmWatch();
    }

    public static void timer() {
        System.out.println("Enter the number of minutes");
        int min = scanner.nextInt();
        System.out.println("Enter the number of seconds");
        int sec = scanner.nextInt();
        System.out.println("Push enter to start");
        scanner.nextLine();
        int setSec = min * 60 + sec;
        while (setSec > 0) {
            sleep(1000);
            System.out.println(--setSec);
        }
    }

    public static void secMeter() {
        System.out.println("Push enter to start");
        scanner.nextLine();
        Long startTime = System.currentTimeMillis();
        System.out.println("Push enter to finish");
        scanner.nextLine();
        Long stopTime = System.currentTimeMillis();
        double timeLapsSec = (stopTime - startTime) / 1000.;
        System.out.println(timeLapsSec);
    }

    public static void alarmWatch() {
        System.out.println("Enter hour");
        int hour = scanner.nextInt();
        System.out.println("Enter minutes");
        int min = scanner.nextInt();

        LocalTime localTime = LocalTime.of(hour, min);
        while (true) {
            int result = LocalTime.now().compareTo(localTime);
            if (result >= 0) {
                System.out.println("Wake up!");
                System.out.println(LocalDateTime.now());
                return;
            }
        }
    }

    public static void sleep(long sleepDurationInMs) {
        try {
            Thread.sleep(sleepDurationInMs);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
