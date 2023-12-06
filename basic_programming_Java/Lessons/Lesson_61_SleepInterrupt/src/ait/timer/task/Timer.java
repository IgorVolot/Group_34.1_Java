package ait.timer.task;

import java.time.LocalTime;

public class Timer implements Runnable {
    int clockPeriod = 1;

    public int getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(clockPeriod * 1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                Thread thread = Thread.currentThread();
                System.out.println(Thread.interrupted());

                System.out.println(thread.isInterrupted());
                System.out.println(thread.getName() + " (aka Timer) say bye, bye");
                break;
            }
        }
    }
}
