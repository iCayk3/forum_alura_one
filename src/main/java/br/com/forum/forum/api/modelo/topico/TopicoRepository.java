package br.com.forum.forum.api.modelo.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("select t from Topico t where t.titulo = :topico")
    Topico existsByTopico(String topico);
}

