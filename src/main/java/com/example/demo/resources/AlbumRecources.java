package com.example.demo.resources;

import com.example.demo.models.AlbumEntity;
import com.example.demo.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

        import java.util.List;
@RestController
@RequestMapping(value = "/albuns")
public class AlbumRecources {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<AlbumEntity> findAll() {
        return albumService.findAll();
    }

    @GetMapping(value = "/{id}")
    public AlbumEntity findById(@PathVariable Integer id) {
        return albumService.findById(id.longValue());
    }

    @PostMapping
    public AlbumEntity insert(@RequestBody AlbumEntity albumEntity) {
        return albumService.insert(albumEntity);
    }

    @PutMapping(value = "/{id}")
    public AlbumEntity update(@PathVariable Integer id, @RequestBody AlbumEntity albumEntity) {
        return albumService.update(id, albumEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        albumService.delete(id.longValue());
    }
}