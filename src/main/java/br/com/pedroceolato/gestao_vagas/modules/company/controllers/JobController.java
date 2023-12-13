package br.com.pedroceolato.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedroceolato.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.pedroceolato.gestao_vagas.modules.company.entities.JobEntity;
import br.com.pedroceolato.gestao_vagas.modules.company.useCases.CreateJobUserCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
     @Autowired
    private CreateJobUserCase createJobUserCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        try {
            var companyId = request.getAttribute("company_id").toString();
            
            var jobEntity = JobEntity.builder()
                .companyId(UUID.fromString(companyId))
                .benefits(createJobDTO.getBenefits())
                .description(createJobDTO.getDescription())
                .level(createJobDTO.getLevel())
                .build();

            var company = this.createJobUserCase.execute(jobEntity);

            return ResponseEntity.ok(company);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
