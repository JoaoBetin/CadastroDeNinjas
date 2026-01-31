package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.*;
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
    public List<MissaoModel> exibirMissoes() {
        return missaoService.exibirMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel exibirMissaoID(@PathVariable long id){
        return missaoService.exibirMissaoID(id);
    }

    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missaoModel){
        return missaoService.criarMissao(missaoModel);
    }
}
