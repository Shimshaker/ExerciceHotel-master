package com.technobel2021.exercicehotel.exception;

public class RoleInvalidException extends RuntimeException {

    public RoleInvalidException() {
        super("Les roles d'un utilisateurs devrait être soit USER ou ADMIN");
    }
}
