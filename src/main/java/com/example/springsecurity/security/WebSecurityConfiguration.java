package com.example.springsecurity.security;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;

/*
 * @author Oksiuta Andrii
 * 06.02.2023
 * 14:59
 */
@Configuration
@Data
@EnableWebSecurity
public class WebSecurityConfiguration {


  private final UserDetailsServiceImpl userDetailsServiceImpl;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsServiceImpl);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(requests -> requests
            .requestMatchers("/index", "/ping", "/login", "/users/registration").permitAll()
            .requestMatchers("/menu").hasAnyAuthority("USER", "ADMIN")
            .requestMatchers("/products/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/menu")
            .permitAll()
        )
        .httpBasic().and()
        .exceptionHandling().accessDeniedPage("/403").and()
        .logout(LogoutConfigurer::permitAll);

    return http.build();
  }
}
