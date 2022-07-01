package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/dados")
public class MunicipalityController {

    @Autowired
    private MunicipalityRepository repository;

    @GetMapping
    public ResponseEntity<List<MunicipalityListDTO>> acharTudo() {
        List<MunicipalityListDTO> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public MunicipalityListDTO acharPorId(@PathVariable Long id) {
        MunicipalityListDTO result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MunicipalityListDTO salvar(@RequestBody MunicipalityListDTO municipality) {
        MunicipalityListDTO result = repository.save(municipality);
        return result;
    }

    @PutMapping
    public MunicipalityListDTO atualizarPorId(@RequestBody MunicipalityListDTO municipality){
        MunicipalityListDTO result = repository.save(municipality);
        return result;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MunicipalityListDTO removerPorId(@PathVariable Long id){
        MunicipalityListDTO result = repository.findById(id).get();
        repository.deleteById(id);
        return result;
    }

    /*@GetMapping
    public ResponseEntity<Page<Municipality>> acharTudo(Pageable pageable){
        Page<Municipality> result = repository.findAll(pageable);
        return ResponseEntity.ok(result);
    }*/

}
