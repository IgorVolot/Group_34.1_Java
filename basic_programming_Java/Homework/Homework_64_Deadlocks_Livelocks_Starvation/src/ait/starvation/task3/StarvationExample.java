package ait.starvation.task3;

public class StarvationExample {
    static class SharedResource {
        synchronized void accessResource(String threadName) {
            System.out.println(threadName + " is accessing the shared resource.");
            try {
                Thread.sleep(1000);  // Simulating some resource-intensive operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class StarvationThread implements Runnable {
        private SharedResource sharedResource;

        public StarvationThread(SharedResource sharedResource) {
            this.sharedResource = sharedResource;
        }

        @Override
        public void run() {
            while (true) {
                sharedResource.accessResource(Thread.currentThread().getName());
            }
        }
    }


    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Thread that causes starvation
        Thread starveThread = new Thread(new StarvationThread(sharedResource), "StarvationThread");
        starveThread.start();

        // Threads that try to access the resource
        for (int i = 0; i < 5; i++) {
            Thread normalThread = new Thread(() -> sharedResource.accessResource("NormalThread"), "NormalThread-" + i);
            normalThread.start();
        }
    }
}
