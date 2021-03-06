package com.william;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by william on 17-3-24.
 */
@SpringBootApplication
public class MainRunner {

    private static Log logger = LogFactory.getLog(MainRunner.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainRunner.class, args);
    }
}
