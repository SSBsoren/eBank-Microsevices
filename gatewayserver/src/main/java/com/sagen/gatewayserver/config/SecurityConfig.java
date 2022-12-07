package com.sagen.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {

        httpSecurity.authorizeExchange(exchange ->
                        exchange.pathMatchers("/e-bank/accounts/**").authenticated()
                                .pathMatchers("/e-bank/loans/**").authenticated()
                                .pathMatchers("/e-bank/cards/**").authenticated()
                                .pathMatchers("/eureka/**").permitAll())
                .oauth2Login(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }


}
