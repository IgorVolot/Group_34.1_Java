package ait.printer.task;

public class Printer implements Runnable{

    static int totalNumberToPrint = 100;
    int clockPeriod; // clock period (in minutes period)
    int number; // number of digits (number of Printer threads)
    Thread nextThread;

    public Printer(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNextThread(Thread nextThread) {
        this.nextThread = nextThread;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod * 60000;
    }

    @Override
    public void run() {
        int index = 0;
        while (index != number){
            index++;
            try {
                Thread.sleep(clockPeriod);
            } catch (InterruptedException e) {
                Thread thread = Thread.currentThread();
                nextThread = thread;
            }
        }
    }
}
