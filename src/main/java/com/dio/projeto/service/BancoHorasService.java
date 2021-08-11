package com.dio.projeto.service;

import com.dio.projeto.model.BancoHoras;
import com.dio.projeto.repository.BancoHorasRepository;
import com.dio.projeto.util.BancoHorasId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {
    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras create(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public Optional<BancoHoras> getById(BancoHorasId idBancoHoras) {
        return bancoHorasRepository.findById(idBancoHoras);
    }

    public List<BancoHoras> findAll() {
        return bancoHorasRepository.findAll();
    }

    public BancoHoras update(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public void delete(BancoHorasId idBancoHoras) {
        bancoHorasRepository.deleteById(idBancoHoras);
    }
}
