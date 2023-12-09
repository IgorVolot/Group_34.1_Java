package ait.elevetor.task;

import ait.elevetor.model.Elevator;

public class Truck implements Runnable {
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();
    private int nRaces;
    private int capacity;
    Elevator elevator1;
    Elevator elevator2;

    public Truck(int nRaces, int capacity, Elevator lenin, Elevator stalin) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator1 = lenin;
        this.elevator2 = stalin;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            if (elevator1.getName().equals("V. I. Lenin")) {
                synchronized (monitor1) {
                    elevator1.add(capacity / 2);
                }
            }
            if (elevator2.getName().equals("Y. V. Stalin")) {
                synchronized (monitor2) {
                    elevator2.add(capacity / 2);
                }
            }
        }
    }
}
