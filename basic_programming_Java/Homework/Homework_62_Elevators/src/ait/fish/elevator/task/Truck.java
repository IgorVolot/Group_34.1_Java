package ait.fish.elevator.task;

import ait.fish.elevator.model.Elevator;

public class Truck implements Runnable {
    private static Object monitor1 = new Object();
    private static Object monitor2 = new Object();
    int nRaces;
    int capacity;
    Elevator[] elevators;

    public Truck(int nRaces, int capacity, Elevator... elevators) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            if (hashCode() % 2 == 0) {
                synchronized (monitor1) {
                    elevators[0].add(capacity / elevators.length);
                }
                synchronized (monitor2) {
                    elevators[1].add(capacity / elevators.length);
                }
            } else {
                synchronized (monitor2) {
                    elevators[1].add(capacity / elevators.length);
                }
                synchronized (monitor1) {
                    elevators[0].add(capacity / elevators.length);
                }
            }
        }
    }
}
