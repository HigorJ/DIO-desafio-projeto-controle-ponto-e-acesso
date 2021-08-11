package com.dio.projeto.service;

import com.dio.projeto.model.CategoriaUsuario;
import com.dio.projeto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaUsuario create(CategoriaUsuario categoriaUsuario) {
        return categoriaRepository.save(categoriaUsuario);
    }

    public Optional<CategoriaUsuario> getById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    public List<CategoriaUsuario> findAll() {
        return categoriaRepository.findAll();
    }

    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario) {
        return categoriaRepository.save(categoriaUsuario);
    }

    public void delete(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}
