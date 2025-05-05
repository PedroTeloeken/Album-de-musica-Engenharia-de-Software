package com.example.demo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Album")
public class AlbumEntity {

    @Id
    @Column(name = "cd_album")
    private Integer id;

    @Column(name = "nm_album", length = 50)
    private String nome;

    @Column(name = "nr_ano")
    private Integer ano;

    @Column(name = "nr_duracao_total_alb", precision = 9, scale = 2)
    private Double duracaoTotal;

    @ManyToMany
    @JoinTable(
            name = "Album_Musica",
            joinColumns = @JoinColumn(name = "cd_album"),
            inverseJoinColumns = @JoinColumn(name = "cd_musica")
    )
    private Set<MusicaEntity> musicas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Album_Artista",
            joinColumns = @JoinColumn(name = "cd_album"),
            inverseJoinColumns = @JoinColumn(name = "cd_artista")
    )
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(Double duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }

    public Set<MusicaEntity> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<MusicaEntity> musicas) {
        this.musicas = musicas;
    }

    public Set<ArtistaEntity> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<ArtistaEntity> artistas) {
        this.artistas = artistas;
    }
}

