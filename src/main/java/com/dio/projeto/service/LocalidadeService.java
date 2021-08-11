package com.dio.projeto.service;

import com.dio.projeto.model.Localidade;
import com.dio.projeto.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {
    LocalidadeRepository localidadeRepository;

    @Autowired
    public LocalidadeService(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    public Localidade create(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public Optional<Localidade> getById(Long idLocalidade) {
        return localidadeRepository.findById(idLocalidade);
    }

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public Localidade update(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public void delete(Long idLocalidade) {
        localidadeRepository.deleteById(idLocalidade);
    }
}
