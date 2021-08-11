package com.dio.projeto.service;

import com.dio.projeto.model.Movimentacao;
import com.dio.projeto.repository.MovimentacaoRepository;
import com.dio.projeto.util.MovimentacaoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {
    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao create(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Optional<Movimentacao> getById(MovimentacaoId idMovimentacao) {
        return movimentacaoRepository.findById(idMovimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao update(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public void delete(MovimentacaoId idMovimentacao) {
        movimentacaoRepository.deleteById(idMovimentacao);
    }
}
