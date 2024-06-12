package com.forezp.filter;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggerFilter implements GlobalFilter, Ordered {

    @Autowired
    private Tracer tracer;

    @Override
    public int getOrder() {
        // 设置过滤器的执行顺序，数值越小越先执行  
        return 900;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 在请求处理之后添加标签和打印 trace ID  
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            String traceId = tracer.currentSpan().context().traceIdString();
            System.out.println("Trace ID: " + traceId);
        }));
    }

}