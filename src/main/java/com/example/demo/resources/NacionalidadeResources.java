package com.example.demo.resources;

import com.example.demo.models.NacionalidadeEntity;
import com.example.demo.services.NacionalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nacionalidade")
public class NacionalidadeResources {

    @Autowired
    private NacionalidadeService nacionalidadeService;

    @GetMapping
    public List<NacionalidadeEntity> findAll() {
        return nacionalidadeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public NacionalidadeEntity findById(@PathVariable Integer id) {
        return nacionalidadeService.findById(id.longValue());
    }

    @PostMapping
    public NacionalidadeEntity insert(@RequestBody NacionalidadeEntity nacionalidadeEntity) {
        return nacionalidadeService.insert(nacionalidadeEntity);
    }

    @PutMapping(value = "/{id}")
    public NacionalidadeEntity update(@PathVariable Integer id, @RequestBody NacionalidadeEntity nacionalidadeEntity) {
        return nacionalidadeService.update(id, nacionalidadeEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        nacionalidadeService.delete(id.longValue());
    }
}

