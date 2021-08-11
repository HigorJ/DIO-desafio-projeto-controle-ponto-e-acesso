package com.dio.projeto.controller;

import com.dio.projeto.model.Movimentacao;
import com.dio.projeto.service.MovimentacaoService;
import com.dio.projeto.util.MovimentacaoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping()
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.create(movimentacao);
    }

    @GetMapping("/list")
    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoService.findAll();
    }

    @GetMapping()
    public ResponseEntity<Movimentacao> getMovimentacaoById(@RequestBody MovimentacaoId idMovimentacao) {
        return ResponseEntity.ok(movimentacaoService.getById(idMovimentacao).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.update(movimentacao);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteMovimentacao(@RequestBody MovimentacaoId idMovimentacao) {
        try {
            movimentacaoService.delete(idMovimentacao);
        }catch (Exception e) {
            System.out.println("Error: " + e.getCause());
        }

        return ResponseEntity.ok("");
    }
}
