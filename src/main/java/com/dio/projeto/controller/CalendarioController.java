package com.dio.projeto.controller;

import com.dio.projeto.model.Calendario;
import com.dio.projeto.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/calendario")
public class CalendarioController {
    @Autowired
    CalendarioService calendarioService;

    @PostMapping()
    public Calendario createCalendario(@RequestBody Calendario calendario) {
        return calendarioService.create(calendario);
    }

    @GetMapping("/list")
    public List<Calendario> getCalendarioList() {
        return calendarioService.findAll();
    }

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> getCalendarioById(@PathVariable("idCalendario") Long idCalendario) {
        return ResponseEntity.ok(calendarioService.getById(idCalendario).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping()
    public Calendario updateCalendario(@RequestBody Calendario calendario) {
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{idCalendario}")
    public ResponseEntity<String> deleteCalendario(@PathVariable("idCalendario") Long idCalendario) {
        try {
            calendarioService.delete(idCalendario);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok("");
    }
}
