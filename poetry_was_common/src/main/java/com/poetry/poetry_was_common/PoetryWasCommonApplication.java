package com.poetry.poetry_was_common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // 비동기 처리를 위한 비동기 설정
@SpringBootApplication(scanBasePackages = "com.poetry.poetry_was_common")
public class PoetryWasCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoetryWasCommonApplication.class, args);
    }

}
