package com.technobel2021.exercicehotel;

import com.technobel2021.exercicehotel.entity.Client;
import com.technobel2021.exercicehotel.entity.MoyenPayement;
import com.technobel2021.exercicehotel.entity.Utilisateur;
import com.technobel2021.exercicehotel.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class ExerciceHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciceHotelApplication.class, args);


    }

}
