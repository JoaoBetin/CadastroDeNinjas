package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;
    }

    public NinjaDTO map(Optional<NinjaModel> ninjaRemovido) {
        return null;
    }
}
