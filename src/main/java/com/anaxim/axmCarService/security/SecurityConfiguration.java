package com.anaxim.axmCarService.security;

import com.anaxim.axmCarService.security.costant.SecurityConstant;
import com.anaxim.axmCarService.security.exceptions.ExceptionsHandling;
import com.anaxim.axmCarService.security.filters.JwtAccessDeniedHandler;
import com.anaxim.axmCarService.security.filters.JwtAuthenticationEntryPoint;
import com.anaxim.axmCarService.security.filters.JwtAuthorizationFilter;
import com.anaxim.axmCarService.user.utility.servicesImpl.AxmUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    private JwtAuthorizationFilter jwtAuthorizationFilter;
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;



    public SecurityConfiguration(JwtAuthorizationFilter jwtAuthorizationFilter,
                                 JwtAccessDeniedHandler jwtAccessDeniedHandler,
                                 JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint){
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }




    @Bean
    public UserDetailsService userDetailsService(){
        return  new AxmUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).disable()
                .authorizeHttpRequests((auth) -> auth.
                        requestMatchers(SecurityConstant.PUBLIC_URLS).permitAll()
                                .anyRequest().authenticated()
                        )
                //.exceptionHandling().accessDeniedHandler(jwtAccessDeniedHandler)
                //.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //.and()
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


}
