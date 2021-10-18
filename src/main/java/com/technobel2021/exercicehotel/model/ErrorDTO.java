package com.technobel2021.exercicehotel.model;

import java.time.Instant;

public class ErrorDTO {

    private String message;
    private Instant timestamp = Instant.now();


    public ErrorDTO(String message){
        this.message = message;

    }
}
