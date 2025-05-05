package com.example.demo.repositories;

import com.example.demo.models.NacionalidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadeRepository extends JpaRepository<NacionalidadeEntity, Long> {

}
