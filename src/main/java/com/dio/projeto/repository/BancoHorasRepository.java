package com.dio.projeto.repository;

import com.dio.projeto.model.BancoHoras;
import com.dio.projeto.util.BancoHorasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHorasId> {
}
