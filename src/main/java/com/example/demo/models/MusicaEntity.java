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

    @Column(name = "nr_duracao_musica", precision = 9, scale = 2)
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
}

