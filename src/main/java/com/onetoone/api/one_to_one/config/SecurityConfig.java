package com.onetoone.api.one_to_one.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  // This will manage user and password details.
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER").and().withUser("admin")
        .password("{noop}password").roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.httpBasic().and().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/v1/users").hasRole("USER")
        .antMatchers(HttpMethod.GET, "/api/v1/users/**").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/api/v1/users").hasRole("ADMIN")
        .and().csrf()
        .disable().formLogin().disable();

  }

}