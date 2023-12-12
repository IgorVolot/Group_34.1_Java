package ait.messages.model;

public class MessageBoxA implements MessageBox {
    private String message;

    @Override
    public synchronized void post(String message) {
        this.message = message;
//        this.notify();
        notify();
    }

    @Override
    public synchronized String get() {
        while (this.message == null){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String res = message;
        message = null;
        return res;
    }
}
