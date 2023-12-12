package ait.deadlock;

public class DeadLockExample implements Runnable {
    private String task1;
    private String task2;

    public DeadLockExample(String task1, String task2) {
        this.task1 = task1;
        this.task2 = task2;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on " + task1);
        synchronized (task1) {
            System.out.println(name + " acquired lock on " + task1);
            work();
            System.out.println(name + " acquiring lock on " + task2);
            synchronized (task2) {
                System.out.println(name + " acquired lock on " + task2);
                work();
            }
            System.out.println(name + " released lock on " + task2);
        }
        System.out.println(name + " released lock on " + task1);
        System.out.println(name + " finished execution.");

    }

    private void work() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
