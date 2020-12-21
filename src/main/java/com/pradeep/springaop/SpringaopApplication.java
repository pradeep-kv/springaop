package com.pradeep.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringaopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringaopApplication.class, args);
    }

}
