package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/municipality")
public class MunicipalityController {

    @Autowired
    private MunicipalityRepository repository;

    @GetMapping
    public ResponseEntity<List<Municipality>> findAll() {
        List<Municipality> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public Municipality findById(@PathVariable Long id) {
        Municipality result = repository.findById(id).get();
        return result;
    }

   /* @PostMapping
    public Municipality insert(@RequestBody Municipality municipality) {
        Municipality result = repository.save(municipality);
        return result;
    }*/

    public static void main(String[] args) {

        SpringApplication.run(MunicipalityController.class, args);
    }
}
