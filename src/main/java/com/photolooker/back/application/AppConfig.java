package com.photolooker.back.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Autorisez les credentials (cookies, jetons d'authentification, etc.)
        config.addAllowedOrigin("http://localhost:4200/"); // Autorisez toutes les origines. Vous pouvez aussi lister les origines spécifiques.
        config.addAllowedHeader("*"); // Autorisez tous les en-têtes
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config); // Appliquez cette configuration à toutes les URL de l'application
        return new CorsFilter(source);
    }
}