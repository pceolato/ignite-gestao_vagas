package br.com.pedroceolato.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedroceolato.gestao_vagas.modules.company.entities.JobEntity;
import br.com.pedroceolato.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUserCase {
   @Autowired
    private JobRepository jobRepository; 

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
