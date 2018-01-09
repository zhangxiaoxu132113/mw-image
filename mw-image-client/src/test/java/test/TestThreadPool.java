package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2018/1/9.
 */
public class TestThreadPool {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(6);
    private static AtomicInteger count = new AtomicInteger();
    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        count.addAndGet(1);
                        System.out.println(count.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
