package ait.watch.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public interface Timer {
    void startTimer(long sec);
    long stopWatch(Scanner scanner);
    LocalTime stopWatchInTime(Scanner scanner);

    void alarm(LocalDateTime timeToWakeUp);
    void pomodoroTimer(Scanner scanner);


}
