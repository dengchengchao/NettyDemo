package com.dengchengchao.demo.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author dengchengchao
 * @date 2020/6/16 22:59
 */
public class Main {


    private static List<Object> list = new ArrayList<>();

    // private static Object[] object=new Object[1024*1024*1000];
    public static void test() {
        //Object object= new Object[100*1024*1024];
    }

    public static void main(String[] args) throws Exception {

        BlockingQueue<File> files=new LinkedBlockingQueue<>();
        Customer customer = new Customer(files);
        Producter producter=new Producter("E:\\StudySpace",files);
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        executorService.execute(customer);
        executorService.execute(producter);


    }
}
