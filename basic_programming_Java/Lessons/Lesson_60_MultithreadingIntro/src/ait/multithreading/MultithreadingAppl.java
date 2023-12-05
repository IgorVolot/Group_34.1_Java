package ait.multithreading;

import ait.multithreading.task.MyTaskExtends;
import ait.multithreading.task.MyTaskImplements;

public class MultithreadingAppl {
    private static final int MAX = 10;
    private static final int SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        MyTaskImplements task1 = new MyTaskImplements("TaskImplements", MAX);
//        task1.run(); так не работает
        Thread thread1 = new Thread(task1);

        MyTaskExtends thread2 = new MyTaskExtends("TaskExtends", MAX);

        MyTaskImplements[] tasks = new MyTaskImplements[SIZE];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new MyTaskImplements("Name#" + i, MAX);
        }
        Thread[] threads = new Thread[SIZE];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tasks[i]);
        }

        thread1.start();
        thread2.start();

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
//            threads[i].join();
        }

        for (int i = 0; i < MAX; i++) {
            System.out.println("Main thread, count = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread1.join();
        thread2.join();
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Main thread finished");
    }
}
