package org.pad;

import java.time.Duration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfiguration {
    private static final Duration TIMEOUT = Duration.ofSeconds(1);

    /**
     * To provide an example of an alternative way to configure the circuit breaker,
     * check the application.properties file to see the same configuration commented out.
     * @return
     */
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .slidingWindowSize(4) //number of requests allowed before the breaker decides whether
                        //the service is working or not, whether the circuit should be open or closed
                        .permittedNumberOfCallsInHalfOpenState(2) //number of calls allowed to pass in half-open state,
                        //and if more than 50% of them fail, the circuit goes again into open state and manages fails
                        .failureRateThreshold(4) //if more than 50% of the requests in the sliding window fail,
                        //the circuit breaker goes into open state
                        .waitDurationInOpenState(Duration.ofSeconds(3)) //and after the defined duration in open state
                        //is over, the circuit goes into half open state, half of the circuit turns off
                        .build())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(TIMEOUT) //for requests
                        .build())
                .build()
        );
    }
}
