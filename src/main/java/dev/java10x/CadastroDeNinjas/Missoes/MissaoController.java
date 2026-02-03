package dev.java10x.CadastroDeNinjas.Missoes;

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
    public List<MissaoDTO> exibirMissoes() {
        return missaoService.exibirMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoDTO exibirMissaoID(@PathVariable long id){
        return missaoService.exibirMissaoID(id);
    }

    @PostMapping("/criar")
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missaoDTO){
        return missaoService.criarMissao(missaoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarID(@PathVariable long id){
        missaoService.deletarID(id);
    }

    @PutMapping("/alterar/{id}")
    public MissaoDTO atualizarPorID(@PathVariable long id, @RequestBody MissaoDTO missaoAtualizada){
        return missaoService.atualizarPorID(id, missaoAtualizada);
    }
}
