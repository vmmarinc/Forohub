package com.alura.forohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.forohub.model.Topico;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}