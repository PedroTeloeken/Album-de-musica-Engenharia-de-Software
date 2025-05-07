package com.example.demo.services;

import com.example.demo.models.AlbumEntity;
import com.example.demo.models.ArtistaEntity;
import com.example.demo.repositories.AlbumRepository;
import com.example.demo.repositories.ArtistaRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<AlbumEntity> findAll() {
        return albumRepository.findAll();
    }

    public AlbumEntity findById(Long id) {
        Optional<AlbumEntity> album = albumRepository.findById(id);
        return album.orElseThrow(() -> new ResourceNotFoundException("Nacionalidade não encontrada"));
    }

    public AlbumEntity insert(AlbumEntity album) {
        return albumRepository.save(album);
    }

    public void delete(Long albumId){
        albumRepository.deleteById(albumId);
    }

    public AlbumEntity update(Integer id, AlbumEntity updatedEntity) {
        AlbumEntity existingEntity = albumRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Nacionalidade não encontrada"));

        existingEntity.setNome(updatedEntity.getNome());
        existingEntity.setAno(updatedEntity.getAno());
        existingEntity.setArtistas(updatedEntity.getArtistas());
        existingEntity.setMusicas(updatedEntity.getMusicas());
        existingEntity.setDuracaoTotal(updatedEntity.getDuracaoTotal());

        return albumRepository.save(existingEntity);
    }
}