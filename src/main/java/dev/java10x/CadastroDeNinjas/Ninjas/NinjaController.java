package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // Exibir todos ninjas
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar ninja";
    }

    // Exibir por ID
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasID(){
        return "Mostrar ninja por ID";
    }

    // Alterar dados ninja
    @PutMapping("/atualizarID")
    public String alterarNinjaPorID(){
        return "Alterar ninja por ID";
    }

    // Deletar ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Deletar por ID";
    }
}
