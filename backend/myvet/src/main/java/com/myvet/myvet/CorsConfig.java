package com.myvet.myvet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Aplica para todos os endpoints
                        .allowedOrigins("http://localhost:4200")  // URL do seu frontend
                        .allowedMethods("GET", "POST","PATCH", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
                        .allowedHeaders("*")  // Headers permitidos
                        .allowCredentials(true)  // Permite enviar cookies/credenciais
                        .maxAge(3600);  // Tempo de cache da resposta preflight (em segundos)
            }
        };
    }
}
