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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Exibir todos ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    // Exibir por ID
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable long id){
        return ninjaService.listarNinjasPorID(id);
    }

    // Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaID(@PathVariable long id){
        ninjaService.deletarNinjaID(id);
    }

    // Alterar ninja
    @PutMapping("/alterar/{id}")
    public NinjaDTO atualizarPorID(@PathVariable long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarPorID(id, ninjaAtualizado);
    }
}
