package com.example.demo.repositories;

import com.example.demo.models.ArtistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<ArtistaEntity, Long> {

}