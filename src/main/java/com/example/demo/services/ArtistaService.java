package com.example.demo.services;

import com.example.demo.models.ArtistaEntity;
import com.example.demo.repositories.ArtistaRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public List<ArtistaEntity> findAll() {
        return artistaRepository.findAll();
    }

    public ArtistaEntity findById(Long id) {
        Optional<ArtistaEntity> company = artistaRepository.findById(id);
        return company.orElseThrow(() -> new ResourceNotFoundException("Nacionalidade não encontrada"));
    }

    public ArtistaEntity insert(ArtistaEntity artistaEntity) {
        return artistaRepository.save(artistaEntity);
    }

    public void delete(Long nacionalidadeId){
        artistaRepository.deleteById(nacionalidadeId);
    }

    public ArtistaEntity update(Integer id, ArtistaEntity updatedEntity) {
        ArtistaEntity existingEntity = artistaRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Nacionalidade não encontrada"));

        existingEntity.setNome(updatedEntity.getNome());
        existingEntity.setAlbuns(updatedEntity.getAlbuns());
        existingEntity.setMusicas(updatedEntity.getMusicas());
        existingEntity.setNacionalidade(updatedEntity.getNacionalidade());

        return artistaRepository.save(existingEntity);
    }
}