package com.dio.projeto.controller;

import com.dio.projeto.model.Empresa;
import com.dio.projeto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @PostMapping()
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.create(empresa);
    }

    @GetMapping("/list")
    public List<Empresa> getEmpresaList() {
        return empresaService.findAll();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("idEmpresa") Long idEmpresa) {
        return ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public Empresa updateEmpresa(@RequestBody Empresa empresa) {
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long idEmpresa) {
        try {
            empresaService.delete(idEmpresa);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}
