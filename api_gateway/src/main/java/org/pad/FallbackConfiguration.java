package org.pad;

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
                .andRoute(RequestPredicates.GET("/giveaway-service-fallback"),
                        this::handleGetFallback)
                .andRoute(RequestPredicates.POST("/base-service-fallback"),
                        this::handlePostFallback)
                .andRoute(RequestPredicates.POST("/giveaway-service-fallback"),
                        this::handlePostFallback)
//                .andRoute(RequestPredicates.GET("/giveawayFallback"),
//                        this::handlePostFallback)
//                .andRoute(RequestPredicates.GET("/productServiceFallback"),
//                        this::handleGetFallback)
//                .andRoute(RequestPredicates.GET("/qtyServiceFallback"),
//                        this::handleGetFallback)
//                .andRoute(RequestPredicates.GET("/packServiceFallback"),
//                        this::handleGetFallback)
//                .andRoute(RequestPredicates.GET("/previewFallback"),
//                        this::handlePostFallback)
//                .andRoute(RequestPredicates.GET("/ownershipFallback"),
//                        this::handlePostFallback)
//                .andRoute(RequestPredicates.POST("/userServiceFallback"),
//                        this::handlePostFallback)
//                .andRoute(RequestPredicates.POST("/giveawayFallback"),
//                        this::handlePostFallback)
//                .andRoute(RequestPredicates.POST("/productServiceFallback"),
//                        this::handleGetFallback)
//                .andRoute(RequestPredicates.POST("/qtyServiceFallback"),
//                        this::handleGetFallback)
//                .andRoute(RequestPredicates.POST("/packServiceFallback"),
//                        this::handleGetFallback)
//                .andRoute(RequestPredicates.POST("/previewFallback"),
//                        this::handlePostFallback)
//                .andRoute(RequestPredicates.POST("/ownershipFallback"),
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
