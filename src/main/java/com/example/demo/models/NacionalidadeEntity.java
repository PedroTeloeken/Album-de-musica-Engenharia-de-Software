package com.example.demo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Nacionalidade")
public class NacionalidadeEntity {

    @Id
    @Column(name = "cd_nacionalidade")
    private Integer id;

    @Column(name = "nm_nacionalidade", length = 50)
    private String nome;

    @OneToMany(mappedBy = "nacionalidade")
    private Set<ArtistaEntity> artistas = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<ArtistaEntity> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<ArtistaEntity> artistas) {
        this.artistas = artistas;
    }
}

