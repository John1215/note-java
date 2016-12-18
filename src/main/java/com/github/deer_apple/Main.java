package com.github.deer_apple;

import com.github.deer_apple.controller.AllController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author lwq
 */
@SpringBootApplication

public class Main {
     public static void main(String[] args) {
        // 或者用maven打包成jar，用java -jar XXX.jar启动
        SpringApplication.run(AllController.class, args);
    }
}
