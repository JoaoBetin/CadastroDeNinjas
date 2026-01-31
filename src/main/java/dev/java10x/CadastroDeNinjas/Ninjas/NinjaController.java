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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Exibir todos ninjas
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    // Exibir por ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id){
        return ninjaService.listarNinjasPorID(id);
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
