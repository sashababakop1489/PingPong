package com.babakov;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
@RequiredArgsConstructor
public class EventProcessor extends Thread {

    private final String event;
    private final BlockingQueue<String> sendTo;
    private final BlockingQueue<String> readFrom;

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            String value = readFrom.take();
            Thread.sleep(100);
            System.out.println(value);
            sendTo.add(event);
        }
    }
}