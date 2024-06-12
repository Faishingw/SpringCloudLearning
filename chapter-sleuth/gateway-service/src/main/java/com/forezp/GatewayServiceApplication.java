package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebFlux

public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Configuration
    static class WebFluxConfig implements WebFluxConfigurer {

        @Override
        public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
            // 自定义codec配置，比如添加自定义的encoder和decoder
            configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024); // 设置最大内存大小
        }

    }
}
