package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.servicies.MunicipalityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/municipality")
public class MunicipalityController {

    @Autowired
    private MunicipalityRepository repository;

    @GetMapping
    public ResponseEntity<List<Municipality>> acharTudo() {
        List<Municipality> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public Municipality acharPorId(@PathVariable Long id) {
        Municipality result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Municipality salvar(@RequestBody Municipality municipality) {
        Municipality result = repository.save(municipality);
        return result;
    }

    /*@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id){
        Municipality result = repository.deleteById(Long id);
    }

    @GetMapping
    public ResponseEntity<Page<Municipality>> acharTudo(Pageable pageable){
        Page<Municipality> result = repository.findAll(pageable);
        return ResponseEntity.ok(result);
    }*/

    public static void main(String[] args) {

        SpringApplication.run(MunicipalityController.class, args);
    }
}
