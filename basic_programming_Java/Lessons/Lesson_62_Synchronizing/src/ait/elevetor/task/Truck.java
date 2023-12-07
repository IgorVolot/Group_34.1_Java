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

    //    @Override
//    public void run() {
//        for (int i = 0; i < nRaces; i++) {
////            synchronized (elevator){    // можно любым стрингом (объектом)
//            synchronized ("cheburashka"){ // можно любым стрингом (объектом), стрингом не практично
//                elevator.add(capacity);
//            }
////            }
//        }
//    }
    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor) {    // более гибкое решение
                elevator.add(capacity);
            }
        }
    }
}
