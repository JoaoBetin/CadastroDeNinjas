package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    MissaoRepository missaoRepository;
    MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> exibirMissoes(){
        List<MissaoModel> missaoModel = missaoRepository.findAll();
        return missaoModel.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO exibirMissaoID(long id){
        Optional<MissaoModel> missaoModel = missaoRepository.findById(id);
        return missaoModel.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public void deletarID(long id){
        missaoRepository.deleteById(id);
    }

    public MissaoDTO atualizarPorID(long id, MissaoDTO missaoUsuario) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissaoModel missaoEntidade = missaoMapper.map(missaoUsuario);
            missaoEntidade.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoEntidade);
            return missaoMapper.map(missaoSalva);
        }
        return null;
    }
}
