package ait.elevetor;

import ait.elevetor.model.Elevator;
import ait.elevetor.task.Truck;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ElevatorAppl {
    private static final int N_TRUCK = 1000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20;
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();

        Elevator lenin = new Elevator("V. I. Lenin");
        Elevator stalin = new Elevator("Y. V. Stalin");

        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            if (i % 2 == 0){
                trucks[i] = new Truck(N_RACES, CAPACITY, lenin);
            } else {
                trucks[i] = new Truck(N_RACES, CAPACITY, stalin);
            }
        }

        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }

        for (Thread thread: threads) {
            thread.join();
        }
        System.out.println("Elevator " + lenin.getName() + " has " + lenin.getCurrentVolume());
        System.out.println("Elevator " + stalin.getName() + " has " + stalin.getCurrentVolume());

        LocalDateTime stop = LocalDateTime.now();
        double sec = ChronoUnit.MILLIS.between(start,stop) * 1.;
        System.out.println(sec);
    }
}
