package com.example.demo.resources;

import com.example.demo.models.ArtistaEntity;
import com.example.demo.services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/artista")
public class ArtistaResources {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public List<ArtistaEntity> findAll() {
        return artistaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ArtistaEntity findById(@PathVariable Integer id) {
        return artistaService.findById(id.longValue());
    }

    @PostMapping
    public ArtistaEntity insert(@RequestBody ArtistaEntity nacionalidadeEntity) {
        return artistaService.insert(nacionalidadeEntity);
    }

    @PutMapping(value = "/{id}")
    public ArtistaEntity update(@PathVariable Integer id, @RequestBody ArtistaEntity nacionalidadeEntity) {
        return artistaService.update(id, nacionalidadeEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        artistaService.delete(id.longValue());
    }
}