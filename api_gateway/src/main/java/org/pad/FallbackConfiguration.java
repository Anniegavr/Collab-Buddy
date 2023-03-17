package com.collab.buddy;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class FallbackConfiguration {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/base-service-fallback"),
                        this::handleGetFallback)
//                .andRoute(RequestPredicates.POST("/schedule-service-fallback"),
//                        this::handlePostFallback)
                        ;
    }

    public Mono<ServerResponse> handleGetFallback(ServerRequest request) {
        return ServerResponse.status(HttpStatus.REQUEST_TIMEOUT).body(Mono.empty(), String.class);
    }

    public Mono<ServerResponse> handlePostFallback(ServerRequest request) {
        return ServerResponse.status(HttpStatus.REQUEST_TIMEOUT).build();
    }
}
