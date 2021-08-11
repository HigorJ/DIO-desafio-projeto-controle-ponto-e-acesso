package com.dio.projeto.repository;

import com.dio.projeto.model.Movimentacao;
import com.dio.projeto.util.MovimentacaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, MovimentacaoId> {
}
