package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ninjaDTO.getNome() + " foi criado com sucesso com id: " + ninjaDTO.getId() +"!");
    }

    // Exibir todos ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas(){
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();

        return ResponseEntity.ok(ninjaDTOList);
    }

    // Exibir por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id){
        NinjaDTO ninjaDTO = ninjaService.listarNinjasPorID(id);

        if(ninjaDTO != null){
            return ResponseEntity.ok(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja nao encontrado para o ID " + id);
    }

    // Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaID(@PathVariable long id){

        if(ninjaService.listarNinjasPorID(id) != null){
            ninjaService.deletarNinjaID(id);
            return ResponseEntity.ok("ID: " + id + " foi removido com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja nao encontrado para o ID " + id);

    }

    // Alterar ninja
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> atualizarPorID(@PathVariable long id, @RequestBody NinjaDTO ninjaAtualizado){
        if(ninjaService.listarNinjasPorID(id) != null){
            ninjaService.atualizarPorID(id, ninjaAtualizado);
            return ResponseEntity.ok(id + " foi atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja nao encontrado para o ID " + id);
    }
}
