package com.babakov;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {

        BlockingQueue<String> fromPingToPong = new LinkedBlockingDeque(100);
        BlockingQueue<String> fromPongToPing = new LinkedBlockingDeque(100);

        Thread ping = new EventProcessor("Ping",fromPingToPong, fromPongToPing);
        Thread pong = new EventProcessor("Pong",fromPongToPing, fromPingToPong);

        ping.start();
        pong.start();

        fromPingToPong.add("Ping");
    }
}
