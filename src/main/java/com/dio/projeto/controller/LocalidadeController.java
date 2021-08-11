package com.dio.projeto.controller;

import com.dio.projeto.model.Localidade;
import com.dio.projeto.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/localidade")
public class LocalidadeController {
    @Autowired
    LocalidadeService localidadeService;

    @PostMapping()
    public Localidade createLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.create(localidade);
    }

    @GetMapping("/list")
    public List<Localidade> getLocalidadeList() {
        return localidadeService.findAll();
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("idLocalidade") Long idLocalidade) {
        return ResponseEntity.ok(localidadeService.getById(idLocalidade).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public Localidade updateLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.update(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity<String> deleteLocalidade(@PathVariable("idLocalidade") Long idLocalidade) {
        try {
            localidadeService.delete(idLocalidade);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}


