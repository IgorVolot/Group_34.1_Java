package ait.mediation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlkQueueImpl<T> implements BlkQueue<T> {
    private Queue<T> message;
    private int maxSize;
    Lock mutex = new ReentrantLock();
    Condition producerWaitingCondition = mutex.newCondition();
    Condition consumerWaitingCondition = mutex.newCondition();

    public BlkQueueImpl(int maxSize) {
        this.message = new LinkedList<>();
        this.maxSize = maxSize;
    }

    @Override
    public void push(T message) {
        mutex.lock();
        try {
            while (this.message.size() != maxSize) {
                try {
                    producerWaitingCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.message.add(message);
            consumerWaitingCondition.signal();
        } finally {
            mutex.unlock();
        }
    }

    @Override
    public T pop() {
        mutex.lock();
        try {
            while (this.message.isEmpty()) {
                try {
                    consumerWaitingCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T res = message.remove();
            producerWaitingCondition.signal();
            return res;
        } finally {
            mutex.unlock();
        }
    }
}
