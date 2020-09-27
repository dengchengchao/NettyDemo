package com.dengchengchao.demo.test;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @author dengchengchao
 * @date 2020/7/26 21:53
 */
public class Producter implements Runnable {

    private final BlockingQueue<File> fileChannel;

    private final File filePath;

    public  Producter(String filePath, BlockingQueue<File> blockingQueue) {
        this.fileChannel = blockingQueue;
        this.filePath = new File(filePath);
    }

    @Override

    public void run() {
        try {
            if (filePath.isDirectory()) {
                indexFile(filePath);
            } else {
                fileChannel.put(filePath);

            }
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }

    }


    private void indexFile(File file) throws InterruptedException {
        if (file.listFiles() != null) {
            for (File f : file.listFiles()) {

                if (f.isDirectory()) {
                    indexFile(f);
                } else {
                    fileChannel.put(f);
                }


            }
        }
    }

}
