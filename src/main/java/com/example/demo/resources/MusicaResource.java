package com.example.demo.resources;

import com.example.demo.models.MusicaEntity;
import com.example.demo.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaResource {

    @Autowired
    private MusicaService musicaService;

    @GetMapping
    public List<MusicaEntity> findAll() {
        return musicaService.findAll();
    }

    @GetMapping("/{id}")
    public MusicaEntity findById(@PathVariable Integer id) {
        return musicaService.findById(id.longValue());
    }

    @PostMapping
    public MusicaEntity insert(@RequestBody MusicaEntity musicaEntity) {
        return musicaService.insert(musicaEntity);
    }

    @PutMapping("/{id}")
    public MusicaEntity update(@PathVariable Integer id, @RequestBody MusicaEntity musicaEntity) {
        return musicaService.update(id, musicaEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        musicaService.delete(id.longValue());
    }
}

