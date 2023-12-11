package ait.fish.elevator;

import ait.fish.elevator.model.Elevator;
import ait.fish.elevator.task.Truck1;

public class ElevatorAppl {

    private static final int N_TRUCK = 1000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator lenin = new Elevator("V. I. Lenin");
        Elevator stalin = new Elevator("I. V. Stalin");
        Truck1[] trucks = new Truck1[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck1(N_RACES, CAPACITY, lenin, stalin);
        }
        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Elevator " + lenin.getName() + " has " + lenin.getCurrentVolume() + " tonn");
        System.out.println("Elevator " + stalin.getName() + " has " + stalin.getCurrentVolume() + " tonn");
    }

}
