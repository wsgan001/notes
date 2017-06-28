package com.william.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by william on 17-6-15.
 */
@Component
public class SpringAsyncService {

    public String sayHello(String who) {
        asyncPrint();
        String result = who + " say hello to william!";
        System.out.println(result + " inner ...");
        return result;
    }

    @Async
    private void asyncPrint() {
        new Runnable() {
            @Override
            public void run() {
                System.out.println("asyncPrint -------- start");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("asyncPrint -------- end");
            }
        };
    }
}
