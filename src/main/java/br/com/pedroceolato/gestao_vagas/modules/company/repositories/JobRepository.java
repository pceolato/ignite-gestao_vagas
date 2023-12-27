package br.com.pedroceolato.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedroceolato.gestao_vagas.modules.company.entities.JobEntity;
import java.util.List;


public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    // "contains - LIKE"
    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
