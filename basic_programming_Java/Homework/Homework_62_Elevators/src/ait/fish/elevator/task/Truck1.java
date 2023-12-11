package ait.fish.elevator.task;

import ait.fish.elevator.model.Elevator;

public class Truck1 implements Runnable{
    static Object monitor = new Object();
    int nRaces;
    int capacity;
    Elevator[] elevators;

    public Truck1(int nRaces, int capacity, Elevator... elevators) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor) {
                elevators[0].add(capacity / elevators.length);
                elevators[1].add(capacity / elevators.length);
            }
        }
    }
}
