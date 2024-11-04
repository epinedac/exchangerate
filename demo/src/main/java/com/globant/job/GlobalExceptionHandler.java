package com.globant.job;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

import reactor.core.publisher.Mono;

@Component
public class GlobalExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(
            ("Error: " + ex.getMessage()).getBytes());
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }
}

