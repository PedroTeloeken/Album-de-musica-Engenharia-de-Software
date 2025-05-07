package com.example.demo.services;
import com.example.demo.models.MusicaEntity;
import com.example.demo.repositories.MusicaRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public List<MusicaEntity> findAll() {
        return musicaRepository.findAll();
    }

    public MusicaEntity findById(Long id) {
        Optional<MusicaEntity> musica = musicaRepository.findById(id);
        return musica.orElseThrow(() -> new ResourceNotFoundException("Música não encontrada"));
    }

    public MusicaEntity insert(MusicaEntity musicaEntity) {
        return musicaRepository.save(musicaEntity);
    }

    public MusicaEntity update(Integer id, MusicaEntity updatedEntity) {
        MusicaEntity existingEntity = musicaRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada"));

        existingEntity.setNome(updatedEntity.getNome());
        existingEntity.setDuracaoTotal(updatedEntity.getDuracaoTotal());
        existingEntity.setAlbuns(updatedEntity.getAlbuns());

        return musicaRepository.save(existingEntity);
    }

    public void delete(Long id) {
        musicaRepository.deleteById(id);
    }
}

