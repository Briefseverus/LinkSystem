package com.example.appname.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.example.appname.repositories.UserRepo;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    @Qualifier("selfUserDetail")
    private UserDetailsService userDetailsService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	     http.csrf().disable()
	         .authorizeRequests()
	             .antMatchers("/admin").hasRole("AD")
	             .antMatchers("/user").hasRole("US")
	             .antMatchers("/visit").permitAll()
	             .and()
	         .formLogin()
	             .loginPage("/login")
	             .usernameParameter("user")
	             .passwordParameter("pass")
	             .defaultSuccessUrl("/checklogin")
	             .failureUrl("/checkError")
	             .and()
	         .exceptionHandling()
	             .accessDeniedPage("/403")
	             .and()
	         .logout()
	             .logoutSuccessUrl("/login")
	             .and()
	         .authorizeRequests()
	             .antMatchers("/admin-home").hasRole("AD")
	             .antMatchers("/user-home").hasRole("US");
	 }

}