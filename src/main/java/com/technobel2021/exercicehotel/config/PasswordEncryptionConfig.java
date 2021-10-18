package com.technobel2021.exercicehotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class PasswordEncryptionConfig {

    @Bean
    public PasswordEncoder encoder(){

        return new BCryptPasswordEncoder();

    }


}
