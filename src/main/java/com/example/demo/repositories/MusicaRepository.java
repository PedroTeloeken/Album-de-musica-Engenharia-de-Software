package com.example.demo.repositories;

import com.example.demo.models.MusicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicaRepository extends JpaRepository<MusicaEntity, Long> {

}