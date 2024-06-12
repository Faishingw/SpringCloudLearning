package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }

//	您提到的是在Spring Boot Actuator 2.2.5版本中，HttpTraceAutoConfiguration并没有直接提供HttpTraceRepository的实现，而是条件性地依赖于它的存在。这是因为Spring Boot Actuator的设计模式是高度灵活的，它允许用户自定义或提供自己的实现，而不是强制使用默认的实现。
//
//	在Spring Boot Actuator 2.2.5版本中，HttpTraceAutoConfiguration类的作用是配置与HTTP追踪相关的端点和组件。它会检查是否存在HttpTraceRepository的实现，并且如果存在，它会继续配置HttpTraceEndpoint，这是一个暴露HTTP追踪信息的端点。
}
