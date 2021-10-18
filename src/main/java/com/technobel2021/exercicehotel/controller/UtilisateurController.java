package com.technobel2021.exercicehotel.controller;

import com.technobel2021.exercicehotel.entity.Utilisateur;
import com.technobel2021.exercicehotel.model.UtilisateurForm;
import com.technobel2021.exercicehotel.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping({"/add"})
    public ResponseEntity<Utilisateur> insert(@Valid @RequestBody UtilisateurForm form){
        return ResponseEntity.ok(utilisateurService.insert(form));

    }

    @GetMapping({"/all"})
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok( utilisateurService.getAll() );
    }

}
