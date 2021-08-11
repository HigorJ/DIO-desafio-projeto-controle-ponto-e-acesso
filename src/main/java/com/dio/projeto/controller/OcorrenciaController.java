package com.dio.projeto.controller;

import com.dio.projeto.model.Ocorrencia;
import com.dio.projeto.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/ocorrencia")
public class OcorrenciaController {
    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping()
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.create(ocorrencia);
    }

    @GetMapping("/list")
    public List<Ocorrencia> getOcorrenciaList() {
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable("idOcorrencia") Long idOcorrencia) {
        return ResponseEntity.ok(ocorrenciaService.getById(idOcorrencia).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.update(ocorrencia);
    }

    @DeleteMapping("/{idOcorrencia}")
    public ResponseEntity<String> deleteOcorrencia(@PathVariable("idOcorrencia") Long idOcorrencia) {
        try {
            ocorrenciaService.delete(idOcorrencia);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}
