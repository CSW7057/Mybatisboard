package com.board.mybatisboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing // Auditing 활성화 하기 위한 어노테이션.
public class MybatisBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisBoardApplication.class, args);
    }

}
