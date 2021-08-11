package com.dio.projeto.service;

import com.dio.projeto.model.Empresa;
import com.dio.projeto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> getById(Long idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa update(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void delete(Long idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }

}
