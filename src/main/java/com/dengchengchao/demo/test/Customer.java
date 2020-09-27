package com.dengchengchao.demo.test;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * @author dengchengchao
 * @date 2020/7/26 21:47
 */
public class Customer implements Runnable {

    private final BlockingQueue<File> fileChannel;

    public Customer(BlockingQueue<File> blockingQueue) {
        this.fileChannel = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                File file = fileChannel.take();
                System.out.println(file.getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }



    }
}
