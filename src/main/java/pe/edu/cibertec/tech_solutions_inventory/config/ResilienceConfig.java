package pe.edu.cibertec.tech_solutions_inventory.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfig {

    @Bean
    public CircuitBreaker circuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50) // Umbral de tasa de fallos en porcentaje
                .waitDurationInOpenState(Duration.ofMillis(1000)) // Tiempo que permanece abierto
                .permittedNumberOfCallsInHalfOpenState(3) // Número de llamadas permitidas en estado medio abierto
                .slidingWindowSize(10) // Tamaño de la ventana deslizante
                .build();

        return CircuitBreaker.of("inventoryService", config); // Nombre del Circuit Breaker
    }
}
