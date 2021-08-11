package com.dio.projeto.service;

import com.dio.projeto.model.TipoData;
import com.dio.projeto.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {
    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    public TipoData create(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public Optional<TipoData> getById(Long idTipoData) {
        return tipoDataRepository.findById(idTipoData);
    }

    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    public TipoData update(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public void delete(Long idTipoData) {
        tipoDataRepository.deleteById(idTipoData);
    }
}
