package ait.elevetor.task;

import ait.elevetor.model.Elevator;

public class Truck implements Runnable {
    private static Object monitor = new Object();
    private int nRaces;

    private int capacity;
    private Elevator elevator;

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            if (i % 2 == 0){
                elevator.add(capacity);
            } else {
                synchronized (monitor){
                    elevator.add(capacity);
                }
            }
        }
    }

}
