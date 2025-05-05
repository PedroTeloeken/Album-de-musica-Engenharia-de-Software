package com.example.demo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artista")
public class ArtistaEntity {

    @Id
    @Column(name = "cd_artista")
    private Integer id;

    @Column(name = "nm_artista", length = 50)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cd_nacionalidade")
    private NacionalidadeEntity nacionalidade;

    @ManyToMany(mappedBy = "artistas")
    private Set<AlbumEntity> albuns = new HashSet<>();

    @ManyToMany(mappedBy = "artistas")
    private Set<MusicaEntity> musicas = new HashSet<>();

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

    public NacionalidadeEntity getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(NacionalidadeEntity nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<AlbumEntity> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(Set<AlbumEntity> albuns) {
        this.albuns = albuns;
    }

    public Set<MusicaEntity> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<MusicaEntity> musicas) {
        this.musicas = musicas;
    }
}
