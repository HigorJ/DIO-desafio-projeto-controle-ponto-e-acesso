package com.dio.projeto.service;

import com.dio.projeto.model.Calendario;
import com.dio.projeto.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {
    CalendarioRepository calendarioRepository;

    @Autowired
    public CalendarioService(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    public Calendario create(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public Optional<Calendario> getById(Long idCalendario) {
        return calendarioRepository.findById(idCalendario);
    }

    public List<Calendario> findAll() {
        return calendarioRepository.findAll();
    }

    public Calendario update(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public void delete(Long idCalendario) {
        calendarioRepository.deleteById(idCalendario);
    }
}
