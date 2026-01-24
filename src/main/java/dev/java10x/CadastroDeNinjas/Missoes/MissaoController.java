package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissaoController {

    @GetMapping("/boasvindasmissao")
    public String missaoBoasVindas(){
        return "missao boas vindas";
    }
}
