package com.example.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        Enabling Auth Access
        httpSecurity.csrf(customizer -> customizer.disable()); // Disabling CSRF Tokens
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());

//        httpSecurity.formLogin(Customizer.withDefaults()); //For WebBrowser
        httpSecurity.httpBasic(Customizer.withDefaults()); //For REST APIs

        /* - Will not work for formLogin, work for Postman
           - Disable formLogin, it will work, Login will be done-a pop-up will appear */
        httpSecurity.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };
//
//        httpSecurity.csrf(custCsrf);

        return httpSecurity.build();
    }
}
