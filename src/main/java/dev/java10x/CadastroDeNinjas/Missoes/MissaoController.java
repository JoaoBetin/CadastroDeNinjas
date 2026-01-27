package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {
    // Adicionar missões
    @PostMapping("/criar")
    public String criarNinja(){
        return "Missão Criada";
    }

    // Exibir todas missões
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar missão";
    }

    // Exibir missões por ID
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasID(){
        return "Mostrar missão por ID";
    }

    // Alterar dados missão
    @PutMapping("/atualizarID")
    public String alterarNinjaPorID(){
        return "Alterar missão por ID";
    }

    // Deletar missão
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Deletar missão por ID";
    }
}
