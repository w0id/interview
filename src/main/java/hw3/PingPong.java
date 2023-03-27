package hw3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong implements Runnable{

    private AtomicInteger counter;
    private String action;
    private int max;
    private Lock lock = new ReentrantLock();;

    public PingPong(AtomicInteger counter, int max, final String action) {
        this.counter = counter;
        this.max = max;
        this.action = action;
    }

    @Override
    public void run(){
        synchronized (counter) {
            while (counter.get() < max) {
                System.out.println(action);
                lock.lock();
                System.out.println(String.format("Объект заблокирован потоком %s",
                        Thread.currentThread().getName()));
                try {
                    System.out.println("Счетчик: " + counter.incrementAndGet());
                } finally {
                    lock.unlock();
                    System.out.println(String.format("Поток %s разблокировал объект",
                            Thread.currentThread().getName()));
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter.notify();
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            counter.notify();
        }
    }
}
