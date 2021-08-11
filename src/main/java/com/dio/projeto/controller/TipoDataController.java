package com.dio.projeto.controller;

import com.dio.projeto.model.TipoData;
import com.dio.projeto.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/tipoData")
public class TipoDataController {
    @Autowired
    TipoDataService tipoDataService;

    @PostMapping()
    public TipoData createTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.create(tipoData);
    }

    @GetMapping("/list")
    public List<TipoData> getTipoDataList() {
        return tipoDataService.findAll();
    }

    @GetMapping("/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable("idTipoData") Long idTipoData) {
        return ResponseEntity.ok(tipoDataService.getById(idTipoData).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public TipoData updateTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.update(tipoData);
    }

    @DeleteMapping("/{idTipoData}")
    public ResponseEntity<String> deleteTipoData(@PathVariable("idTipoData") Long idTipoData) {
        try {
            tipoDataService.delete(idTipoData);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}
