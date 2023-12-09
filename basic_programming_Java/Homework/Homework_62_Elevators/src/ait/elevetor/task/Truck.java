package ait.elevetor.task;

import ait.elevetor.model.Elevator;

public class Truck implements Runnable {
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();
    private int nRaces;
    private int capacity;
    private Elevator elevator;
    Elevator lenin = new Elevator("V. I. Lenin");
    Elevator stalin = new Elevator("Y. V. Stalin");

    public Truck(int nRaces, int capacity, Elevator lenin, Elevator stalin) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.lenin = lenin;
        this.stalin = stalin;
    }

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            if (elevator.getName().equals("V. I. Lenin")) {
                synchronized (monitor1) {
                    elevator.add(capacity);
                }
            }
            if (elevator.getName().equals("Y. V. Stalin")) {
                synchronized (monitor2) {
                    elevator.add(capacity);
                }
            }
        }
    }


//    @Override
//    public void run() {
//        switch (elevator.getName()) {
//            case ("V. I. Lenin"):
//                synchronized (monitor1) {
//                    elevator.add(capacity);
//                }
//                break;
//            case ("Y. V. Stalin"):
//                synchronized (monitor2) {
//                    elevator.add(capacity);
//                }
//                break;
//        }
//    }
}
