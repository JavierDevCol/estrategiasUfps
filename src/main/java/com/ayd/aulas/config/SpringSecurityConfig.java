package com.ayd.aulas.config;

import com.ayd.aulas.auth.filter.JWTAuthenticationFilter;
import com.ayd.aulas.auth.filter.JWTAuthorizationFilter;
import com.ayd.aulas.auth.service.JWTService;
import com.ayd.aulas.service.seguridad.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;


@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*.antMatchers("/ver/**").hasAnyRole("USER")*/
        /*.antMatchers("/uploads/**").hasAnyRole("USER")*/
        /*.antMatchers("/form/**").hasAnyRole("ADMIN")*/
        /*.antMatchers("/eliminar/**").hasAnyRole("ADMIN")*/
        /*.antMatchers("/factura/**").hasAnyRole("ADMIN")*/
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService))
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
