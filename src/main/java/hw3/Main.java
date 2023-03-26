package hw3;

import java.util.concurrent.atomic.AtomicInteger;

public class Main{

    public static void main(String[] args){
        AtomicInteger counter = new AtomicInteger(0);
        int max = 10;
        Thread ping = new Thread(new PingPong(counter, max, "PING"), "Ping");
        Thread pong = new Thread(new PingPong(counter, max, "PONG"), "Pong");
        try {
            ping.start();
            pong.start();
            ping.join();
            pong.join();
            System.out.println("Done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
