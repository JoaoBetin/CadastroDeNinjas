package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private RankMissao rank;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    public MissaoModel() {
    }

    public MissaoModel(Long id, String nome, RankMissao rank) {
        this.id = id;
        this.nome = nome;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RankMissao getRank() {
        return rank;
    }

    public void setRank(RankMissao rank) {
        this.rank = rank;
    }

}
