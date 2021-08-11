package com.dio.projeto.controller;

import com.dio.projeto.model.NivelAcesso;
import com.dio.projeto.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/nivelAcesso")
public class NivelAcessoController {
    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping()
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.create(nivelAcesso);
    }

    @GetMapping("/list")
    public List<NivelAcesso> getNivelAcessoList() {
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable("idNivelAcesso") Long idNivelAcesso) {
        return ResponseEntity.ok(nivelAcessoService.getById(idNivelAcesso).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.update(nivelAcesso);
    }

    @DeleteMapping("/{idNivelAcesso}")
    public ResponseEntity<String> deleteNivelAcesso(@PathVariable("idNivelAcesso") Long idNivelAcesso) {
        try {
            nivelAcessoService.delete(idNivelAcesso);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}
