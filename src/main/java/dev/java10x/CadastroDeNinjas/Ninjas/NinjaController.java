package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {
    NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // Exibir todos ninjas
    @GetMapping("/listarNinjas")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    // Exibir por ID
    @GetMapping("/listarNinjasPorID")
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
