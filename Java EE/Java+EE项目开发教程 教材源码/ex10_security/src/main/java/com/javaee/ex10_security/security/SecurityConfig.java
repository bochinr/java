package com.javaee.ex10_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private TeachingUserSecurityService teachingUserSecurityService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(teachingUserSecurityService).
                passwordEncoder(new Pbkdf2PasswordEncoder());
    }
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/commons/**","/images/**").permitAll()
                .antMatchers("/book/**").hasRole("TEACHER")
                .antMatchers("/publisher/**").hasRole("SERVICE_ADMIN")
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/commons/to_login")
                .usernameParameter("loginName")
                .defaultSuccessUrl("/")
                .failureUrl("/commons/denied_access");
        http.logout()
                .logoutUrl("/commons/user_logout")
                .logoutSuccessUrl("/commons/to_login");

    }

}
