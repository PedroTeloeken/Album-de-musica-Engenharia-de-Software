package com.example.demo.services;

import com.example.demo.models.NacionalidadeEntity;
import com.example.demo.repositories.NacionalidadeRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NacionalidadeService {

    @Autowired
    private NacionalidadeRepository nacionalidadeRepository;

    public List<NacionalidadeEntity> findAll() {
        return nacionalidadeRepository.findAll();
    }

    public NacionalidadeEntity findById(Long id) {
        Optional<NacionalidadeEntity> company = nacionalidadeRepository.findById(id);
        return company.orElseThrow(() -> new ResourceNotFoundException("Nacionalidade não encontrada"));
    }

    public NacionalidadeEntity insert(NacionalidadeEntity nacionalidadeEntity) {
        return nacionalidadeRepository.save(nacionalidadeEntity);
    }

    public void delete(Long  nacionalidadeId){
        nacionalidadeRepository.deleteById(nacionalidadeId);
    }

    public NacionalidadeEntity update(Integer id, NacionalidadeEntity updatedEntity) {
        NacionalidadeEntity existingEntity = nacionalidadeRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Nacionalidade não encontrada"));

        existingEntity.setNome(updatedEntity.getNome());

        return nacionalidadeRepository.save(existingEntity);
    }
}
