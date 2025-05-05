package com.example.demo.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Musica")
public class MusicaEntity {

    @Id
    @Column(name = "cd_musica")
    private Integer id;

    @Column(name = "nm_musica", length = 50)
    private String nome;

    @Column(name = "nr_duracao_musica")
    private Double duracao;

    @ManyToMany(mappedBy = "musicas")
    private Set<AlbumEntity> albuns = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Artista_Musica",
            joinColumns = @JoinColumn(name = "cd_musica"),
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

    public Double getDuracaoTotal() {
        return duracao;
    }

    public void setDuracaoTotal(Double duracaoTotal) {
        this.duracao = duracaoTotal;
    }

    public Set<AlbumEntity> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(Set<AlbumEntity> albuns) {
        this.albuns = albuns;
    }

    public Set<ArtistaEntity> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<ArtistaEntity> artistas) {
        this.artistas = artistas;
    }
}

