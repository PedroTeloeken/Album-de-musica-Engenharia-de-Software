package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Nacionalidade")
public class NacionalidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_nacionalidade")
    private Integer id;

    @Column(name = "nm_nacionalidade", length = 50)
    private String nome;

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

}

