package com.technobel2021.exercicehotel.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.management.relation.Role;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Validated
public class LoginForm {

    @NotBlank
    String username;
    @NotBlank
    String password;



}
