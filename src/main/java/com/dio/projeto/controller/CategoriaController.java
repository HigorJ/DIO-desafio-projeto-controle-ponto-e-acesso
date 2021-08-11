package com.dio.projeto.controller;

import com.dio.projeto.model.CategoriaUsuario;
import com.dio.projeto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping()
    public CategoriaUsuario createCategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaService.create(categoriaUsuario);
    }

    @GetMapping("/list")
    public List<CategoriaUsuario> getCategoriaList() {
        return categoriaService.findAll();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaUsuario> getCategoriaById(@PathVariable("idCategoria") Long idCategoria) {
        return ResponseEntity.ok(categoriaService.getById(idCategoria).orElseThrow(() -> new NoSuchElementException("Not found")));
    }

    @PutMapping()
    public CategoriaUsuario updateCategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaService.update(categoriaUsuario);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<String> deleteCategoria(@PathVariable("idCategoria") Long idCategoria) {
        try {
            categoriaService.delete(idCategoria);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }

}
