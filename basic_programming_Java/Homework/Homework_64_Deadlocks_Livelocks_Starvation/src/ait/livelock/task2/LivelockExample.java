package ait.livelock.task2;

public class LivelockExample {
    static class Worker {
        private boolean workDone = false;

        public void doWork(Worker colleague) {
            while (!workDone) {
                System.out.println(Thread.currentThread().getName() + " trying to work, but waiting for colleague");
                try {
                    Thread.sleep(100);  // Simulating some operation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (colleague.isWorkDone()) {
                    System.out.println(Thread.currentThread().getName() + " found colleague has finished work, so I'll work now");
                    workDone = true;
                } else {
                    System.out.println(Thread.currentThread().getName() + " still waiting for colleague to finish work");
                }
            }
        }
        public boolean isWorkDone() {
            return workDone;
        }
    }

    public static void main(String[] args) {
        final Worker worker1 = new Worker();
        final Worker worker2 = new Worker();

        Thread thread1 = new Thread(() -> worker1.doWork(worker2), "Worker-1");
        Thread thread2 = new Thread(() -> worker2.doWork(worker1), "Worker-2");

        thread1.start();
        thread2.start();
    }
}
