package com.william.async;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by william on 17-6-15.
 */
public class SpringAsyncTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-async-context.xml");
        SpringAsyncService asyncService = context.getBean(SpringAsyncService.class);
        System.out.println(asyncService.sayHello("carl") + " outer...");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
