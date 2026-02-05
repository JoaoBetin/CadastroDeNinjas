package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {
    MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> exibirMissoes() {
        List<MissaoDTO> missaoDTOList = missaoService.exibirMissoes();

        if (!missaoDTOList.isEmpty()) {
            return ResponseEntity.ok(missaoDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nenhuma missao cadastrada!");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> exibirMissaoID(@PathVariable long id) {
        MissaoDTO missaoDTO = missaoService.exibirMissaoID(id);

        if (missaoDTO != null) {
            return ResponseEntity.ok(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("ID: " + id + " nao foi encontrado!");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = missaoService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missao.getNome() + " foi criado com ID: " + missao.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarID(@PathVariable long id){

        if(missaoService.exibirMissaoID(id) != null){
            missaoService.deletarID(id);
            return ResponseEntity.ok("Missao com id " + id + " foi removida com sucesso!");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("ID: " + id + " nao foi encontrado!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> atualizarPorID(@PathVariable long id, @RequestBody MissaoDTO missaoAtualizada){

        if(missaoService.exibirMissaoID(id) != null){
            missaoService.atualizarPorID(id, missaoAtualizada);
            return ResponseEntity.ok(id + " foi atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("ID: " + id + " nao foi encontrado!");
    }
}
