package com.technobel2021.exercicehotel.config;

import com.technobel2021.exercicehotel.security.JwtAuthorizationFilter;
import com.technobel2021.exercicehotel.security.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService Service;
    private final JwtProvider jwtProvider;

    public WebSecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService Service, JwtProvider jwtProvider) {
        this.passwordEncoder = passwordEncoder;
        this.Service = Service;
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder.encode("pass")).authorities("ADMIN", "USER")
//                .and()
//                .withUser("user").password(passwordEncoder.encode("pass")).authorities("USER");

        auth.userDetailsService( Service );

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();

        http.addFilterBefore(new JwtAuthorizationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.httpBasic();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/client/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/client/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/client/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/client/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET, "/reservation/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/reservation/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/reservation/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/reservation/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET, "/chambre/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/chambre/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/chambre/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/chambre/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority("ADMIN")
                .anyRequest().permitAll();


        // Pour H2
        http.headers()
                .frameOptions()
                .disable();



    }
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

}
