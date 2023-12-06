package ait.timer.task;

import java.time.Instant;
import java.time.LocalTime;

public class TimerMySleep implements Runnable {
    int clockPeriod = 1;

    public int getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                mySleep(clockPeriod * 1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                Thread thread = Thread.currentThread();
                System.out.println(Thread.interrupted());

                System.out.println(thread.isInterrupted());
                System.out.println(thread.getName() + " (aka TimerMySleep) say bye, bye");
                break;
            }
        }
    }

    private void mySleep(long period) throws InterruptedException {
        Instant currentTime = Instant.now();
        Instant timeOfFinish = currentTime.plusMillis(period);
        while (currentTime.isBefore(timeOfFinish)){
            if (Thread.currentThread().isInterrupted()){
                throw new InterruptedException();
            }
//            if (Thread.interrupted()){
//                throw new InterruptedException();
//            }
            currentTime = Instant.now();
        }
    }
}
