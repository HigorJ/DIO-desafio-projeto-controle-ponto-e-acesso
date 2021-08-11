package com.dio.projeto.service;

import com.dio.projeto.model.Ocorrencia;
import com.dio.projeto.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {
    OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Ocorrencia create(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public Optional<Ocorrencia> getById(Long idOcorrencia) {
        return ocorrenciaRepository.findById(idOcorrencia);
    }

    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia update(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void delete(Long idOcorrencia) {
        ocorrenciaRepository.deleteById(idOcorrencia);
    }
}
