package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> exibirMissoes(){
        return missaoRepository.findAll();
    }

    public MissaoModel exibirMissaoID(long id){
        Optional<MissaoModel> missaoModel = missaoRepository.findById(id);
        return missaoModel.orElse(null);
    }

    public MissaoModel criarMissao(MissaoModel missaoModel){
        return missaoRepository.save(missaoModel);
    }

    public void deletarID(long id){
        missaoRepository.deleteById(id);
    }

    public MissaoModel atualizarPorID(long id, MissaoModel missaoAtualizada){
        if(missaoRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missaoRepository.save(missaoAtualizada);
        }
        return null;
    }

}
