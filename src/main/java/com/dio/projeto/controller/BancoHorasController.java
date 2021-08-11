package com.dio.projeto.controller;

import com.dio.projeto.model.BancoHoras;
import com.dio.projeto.service.BancoHorasService;
import com.dio.projeto.util.BancoHorasId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/bancoHoras")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping()
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.create(bancoHoras);
    }

    @GetMapping("/list")
    public List<BancoHoras> getBancoHorasList() {
        return bancoHorasService.findAll();
    }

    @GetMapping()
    public ResponseEntity<BancoHoras> getBancoHorasById(@RequestBody BancoHorasId idBancoHoras) {
        return ResponseEntity.ok(bancoHorasService.getById(idBancoHoras).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.update(bancoHoras);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBancoHoras(@RequestBody BancoHorasId idBancoHoras) {
        try {
            bancoHorasService.delete(idBancoHoras);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}
