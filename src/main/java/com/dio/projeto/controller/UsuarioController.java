package com.dio.projeto.controller;

import com.dio.projeto.model.Usuario;
import com.dio.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @GetMapping("/list")
    public List<Usuario> getUsuarioList() {
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") Long idUsuario) {
        return ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(() -> new NoSuchElementException("Not found")));
    }

    @PutMapping()
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("idUsuario") Long idUsuario) {
        try {
            usuarioService.delete(idUsuario);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}
