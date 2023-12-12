package ait.deadlock.task1;

import ait.deadlock.DeadLockExample;

public class TestDeadlockExampleAppl {
    public static void main(String[] args) throws InterruptedException {
        String task1 = "Task1";
        String task2 = "Task2";
        String task3 = "Task3";

        Thread thread1 = new Thread(new DeadLockExample(task1, task2), task1);
        Thread thread2 = new Thread(new DeadLockExample(task2, task3), task2);
        Thread thread3 = new Thread(new DeadLockExample(task3, task1), task3);

        thread1.start();
        Thread.sleep(500);
        thread2.start();
        Thread.sleep(500);
        thread3.start();
    }
}
